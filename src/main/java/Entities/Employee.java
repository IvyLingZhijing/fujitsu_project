package Entities;

import Constants.CONSTANT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;

    public void setName(String name) {
        String[] fullName = name.trim().split(CONSTANT.SPLIT_NAME_SIGN);
        if (fullName.length != 2 ) {
            System.out.println(String.format("Ops, there is an error in the %s name input.", name));
            return;
        }
        firstName = fullName[0].trim();
        lastName = fullName[1].trim();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Employee other = (Employee) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

}
