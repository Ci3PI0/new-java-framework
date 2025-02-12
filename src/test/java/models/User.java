package models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class User {
	int id;
	String username;
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;
	int userStatus;
}
