package seedu.address.model.tutorialgroup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TutorialGroupTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TutorialGroup(null));
    }

    @Test
    public void constructor_invalidTutorialGroupName_throwsIllegalArgumentException() {
        String invalidTutorialGroupName = "";
        assertThrows(IllegalArgumentException.class, () -> new TutorialGroup(invalidTutorialGroupName));
    }

    @Test
    public void isValidTutorialGroupName() {
        assertThrows(NullPointerException.class, () ->
            TutorialGroup.isValidTutorialGroupName(null)); // null tutorial group name

        assertFalse(TutorialGroup.isValidTutorialGroupName("")); // empty tutorial group
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2040S")); // without tutorial name
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS50 T01")); // module code only 2 digits
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2040S  T05")); // 2 spaces
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2040S T05-")); // end with hyphen
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2040S -T05")); // tutorial name start with hyphen
        assertFalse(TutorialGroup.isValidTutorialGroupName(
            "CS2040S T05!")); // tutorial name has special character
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2040S* T05")); // module has special character
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2106 "
            + "W5124541414124112321321312321312323132332131313131141"
            + "4124112321321312321312323132332131313131")); // tutorial group with 100 characters
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2106 "
            + "W5124541414124112321321312321312323132332131313131141"
            + "4124112321321312321312323132332131313131")); // tutorial group with 100 characters
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2106 "
            + "W51245414141241123213421312321312323132332131313131141"
            + "4124112321321312321312323132332131313131")); // tutorial group with 101 characters
        assertFalse(TutorialGroup.isValidTutorialGroupName("CS2106 "
            + "W000000000000000000000000000000000000000000000"
            + "0000000000000")); // long tutorial group with only 0 digits for tutorial name.

        assertTrue(TutorialGroup.isValidTutorialGroupName("CS2106 "
            + "W512454141412411232132131232131232313233213131313114141"
            + "2411232132131232131232313233213131313")); // tutorial group with 99 characters
        assertTrue(TutorialGroup.isValidTutorialGroupName("CS2106 T05")); // valid tutorial group
        assertTrue(TutorialGroup.isValidTutorialGroupName("CS2103T W15-3")); // hyphen
        assertTrue(TutorialGroup.isValidTutorialGroupName(
            "CS2106 5")); // only has tutorial name with one non-zero digit
    }
}
