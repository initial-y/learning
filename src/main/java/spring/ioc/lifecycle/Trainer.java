package spring.ioc.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xin.yang
 * @className Trainer
 * @description
 * @date 2021/09/22
 */
@Component
public class Trainer {

    private Player player;

    @Value("trainer")
    private String name;

    @Autowired
    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
