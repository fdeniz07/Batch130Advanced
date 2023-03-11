package serialization;

import java.io.Serializable;

//Bu class'in object'leri serilestiribilsin diye belirttik. Mutlaka belirtilmelidir.
public class User implements Serializable {

    private long id;
    private String name;
    private String tc_no;

    public User(long id, String name, String tc_no) {
        this.id = id;
        this.name = name;
        this.tc_no = tc_no;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tc_no='" + tc_no + '\'' +
                '}';
    }
}
