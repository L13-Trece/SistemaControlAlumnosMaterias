package controllers;

import java.util.Map;

@RestController
@RequestMapping("/auth")

public class UserController {
	
	@Autowired
	
	private UserService userService;
	
	//ENDPOINT PARA REGISTRAR USUARIO
	@PostMapping("/signup")
	
	public Map<String, String> signup(@RequestBody User user) {
		userService.signup(user);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Usuario registrado exitosamente.");
		return response;
	}
	
	//ENDPOINT PARA AUTENTICAR Y DEVOLVER EL TOKEN
	@PostMapping("/signin")
	
	public Map<String, String> signin(@RequestParam String username, @RequestParam String password){
		String token = userService.signin(username, password);
		Map<String, String> response2 = new HashMap<>();
		response.put("token", token);
		return response;
		
	}

}
