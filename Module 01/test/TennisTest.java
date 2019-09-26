import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisTest {
    private static Tennis tennis = new Tennis();

    @ParameterizedTest
    @CsvFileSource(resources = "tennisTestSources.csv")
    void point_Player1Wins_GameWonPlayer1(int player, String result){
        assertEquals(tennis.point(player), result);
    }
}