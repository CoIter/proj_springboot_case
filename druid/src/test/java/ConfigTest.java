import com.alibaba.druid.filter.config.ConfigTools;

/**
 * ConfigTest
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/16
 */
//@SpringBootTest
public class ConfigTest {
//    @Test
    public void testDesrpt() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        String plainText = "123456";
        System.out.printf(ConfigTools.encrypt(plainText));
    }
}
