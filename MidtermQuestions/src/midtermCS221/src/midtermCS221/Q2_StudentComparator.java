package PreparingQuestions.MidtermQuestions.src.midtermCS221.src.midtermCS221;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2_StudentComparator {
    public static void main(String[] args){
        List<Student>   stdList = new ArrayList<>();
        stdList.add(new Student("Zaineh", "Altarawneh"));
        stdList.add(new Student("Ferdinand", "Zillatra"));
        stdList.add(new Student("Jasmine", "Jullz"));
        stdList.add(new Student("Jasmine", "Altarawneh"));

        //System.out.println(stdList);
        StudentComparator comp = new StudentComparator();
       Collections.sort(stdList, comp);
        System.out.println(stdList);
        //expecting result: [Ferdinand Zillatra, Jasmine Altarawneh, Jasmine Jullz, Zaineh Altarawneh]
    }
}
