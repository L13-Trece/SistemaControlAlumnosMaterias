package models;

import java.util.List;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String username;
	private String password;
	private String email;
	
	@ElementCollection(fetch = FetchType.EAGER)
	
	private List<String> roles;

}
