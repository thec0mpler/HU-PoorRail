import org.hu.richrail.cli.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class cli_interpreter {
    private static Client client = Client.getInstance();

    @Test
    void createNewWagon() throws Exception {
        assertEquals(
                "",
                client.execute("new wagon wg1")
        );
    }
}
