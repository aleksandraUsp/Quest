import com.javarush.quest.entities.Game;
import com.javarush.quest.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    final UserService userService = UserService.USER_SERVICE;

    @Test
    @DisplayName("Comparing status and responses for step 0")
    public void getFirstQuestWhenDuringStepIs() {
        List<String> quest = userService.getFirstQuest(0);
        assertEquals("Ты потерял память.Принять вызов НЛО?", quest.get(0));
        assertEquals("Принять вызов", quest.get(1));
        assertEquals("Отклонить вызов", quest.get(2));
    }

    @ParameterizedTest
    @DisplayName("Comparing status and responses for steps 1-6")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void getFirstQuestWhenDuringStepIs_1_6(int duringStep) {
        if (duringStep == 1) {
            List<String> testedQuest = userService.getFirstQuest(duringStep);
            assertEquals("Ты принял вызов. Поднимаешься на мостик к капитану?", testedQuest.get(0));
            assertEquals("Подняться на мостик", testedQuest.get(1));
            assertEquals("Отказаться подниматься на мостик", testedQuest.get(2));
        }
        if (duringStep == 2) {
            List<String> testedQuest = userService.getFirstQuest(duringStep);
            assertEquals("Ты поднялся на мостик. Ты кто?", testedQuest.get(0));
            assertEquals("Рассказать правду о себе", testedQuest.get(1));
            assertEquals("Солгать о себе", testedQuest.get(2));
        }
        if (duringStep == 3) {
            List<String> testedQuest = userService.getFirstQuest(duringStep);
            assertEquals("Тебя вернули домой. Победа", testedQuest.get(0));
            assertEquals("Нет вариантов", testedQuest.get(1));
            assertEquals("Нет вариантов", testedQuest.get(2));
        }
        if (duringStep == 4) {
            List<String> testedQuest = userService.getFirstQuest(duringStep);
            assertEquals("Ты не пошел на переговоры. Поражение", testedQuest.get(0));
            assertEquals("Нет вариантов", testedQuest.get(1));
            assertEquals("Нет вариантов", testedQuest.get(2));
        }
        if (duringStep == 5) {
            List<String> testedQuest = userService.getFirstQuest(duringStep);
            assertEquals("Твою ложь разоблачили. Поражение", testedQuest.get(0));
            assertEquals("Нет вариантов", testedQuest.get(1));
            assertEquals("Нет вариантов", testedQuest.get(2));
        }
        if (duringStep == 6) {
            List<String> testedQuest = userService.getFirstQuest(duringStep);
            assertEquals("Ты отклонил вызов. Поражение", testedQuest.get(0));
            assertEquals("Нет вариантов", testedQuest.get(1));
            assertEquals("Нет вариантов", testedQuest.get(2));
        }

    }
    @ParameterizedTest
    @DisplayName("Testing getting the next step when during step and answer of during step is")
    @CsvSource({
            "0, 1",
            "0, 2",
            "1, 1",
            "1, 2",
            "2, 1",
            "2, 2",
            "8, 10"

    })
    public void getNextStepWhenStepIs(int step, int numberOfAnswer){
        int nextStep = userService.getNextStep(step, numberOfAnswer);
        if (step==0 & numberOfAnswer==1) {
            assertEquals(1, nextStep);
        }
        else if (step==0 & numberOfAnswer==2) {
            assertEquals(6, nextStep);
        }
        else if (step==1 & numberOfAnswer==1) {
            assertEquals(2, nextStep);
        }
        else if (step==1 & numberOfAnswer==2) {
            assertEquals(4, nextStep);
        }
        else if (step==2 & numberOfAnswer==1) {
            assertEquals(3, nextStep);
        }
        else if (step==2 & numberOfAnswer==2) {
            assertEquals(5, nextStep);
        }
        else assertEquals(1000001, nextStep);

    }
    @ParameterizedTest
    @DisplayName("Testing getting the game state when during step is")
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 20, 30})
    public void getGameStateWhenStepIs (int step){
        Game state = userService.getGameState(step);
        if (step==3)
            assertEquals(Game.WIN, state);
        else if (step==4 || step==5 || step==6)
            assertEquals(Game.LOSE, state);
        else
            assertEquals(Game.GAME, state);
    }

}
