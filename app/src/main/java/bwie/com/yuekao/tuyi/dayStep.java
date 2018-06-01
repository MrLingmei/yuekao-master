package bwie.com.yuekao.tuyi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zld on 2018.06.01.
 */
@Entity
public class dayStep {
    @Id
    Long id;
    String name;
    @Generated(hash = 1099736830)
    public dayStep(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1348095957)
    public dayStep() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
