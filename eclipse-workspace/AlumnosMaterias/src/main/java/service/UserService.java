package service;

import securiry.JwtTokenProvider;

@Service

public class UserService implements UserDetailsService {
	
	@Autowired
	
	private UserRepository userRepository;
	
	@Autowired
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	
	private JwtTokenProvider jwtTokenProvider;
	
	
	//REGISTRAR NUEVO USUSARIO
	public user signup (user user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new RuntimeException ("El nombre de usuario ya esta en uso.");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	//AUTENTICAR USUARIO
	public String signin(String username, String password) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password));
		return jwtTokenProvider.generateToken(authentication);
	}
	
	//CARGAR USUSARIO POR NOMBRE DE USUSARIO
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() ->new UsernameNotFoundExcepetion("Usuario no encontrado."));
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.authorities(user.getRoles())
				.build();
	}

}
