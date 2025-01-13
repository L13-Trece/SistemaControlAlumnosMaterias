package repository;

public class UserRepository  extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
    boolen existsByUsername (String username);

}
