package admission.security;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import admission.dao.UserRepository;
import admission.domain.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {

		User userOptional = userRepository.findByNickName(nickName);

		if (userOptional != null) {
			User user = userOptional;
			return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
		}
		throw new UsernameNotFoundException("No user present with this nickname:" + nickName);
	}

}
