package securiry;

public class JwtTokenFilter extends OncePerRequestFilter {
	
	@Autowired 
	
	private JwtTokenProvider tokenProvider;
	
	@Override
	
	protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	throws ServletException, IOException {
		String token = getJwtFromRequest(request);
		
		if (token != null && tokenProvider.validateToken(token)) {
			String username = tokenProvider.getUsernameFromToken(token);
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthentication(username));
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

}
