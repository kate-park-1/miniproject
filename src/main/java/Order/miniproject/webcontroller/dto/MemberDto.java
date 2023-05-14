package Order.miniproject.webcontroller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto { // 변경
  Long id;
  String name;
  String loginId;
  String password;
  //Address address; ==> 수정
  String city;
  String street;
  String zipcode;
}
