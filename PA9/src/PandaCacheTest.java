import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PandaCacheTest {

    PandaCache test1;
    @BeforeEach
    public void setter(){
        test1 = new PandaCache(3);
    }

    @Test
    public void testSet(){
        test1.set(123, 1);
        test1.set(456, 2);
        test1.set(789, 1);

        assertEquals(test1.get(123), 1);
        test1.set(999, 3);
        assertEquals(test1.get(456), -1);
    }
}