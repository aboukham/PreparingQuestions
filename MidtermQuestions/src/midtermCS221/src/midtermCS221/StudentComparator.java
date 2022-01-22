package PreparingQuestions.MidtermQuestions.src.midtermCS221.src.midtermCS221;

import java.util.Comparator;

public class StudentComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        if (s1.getFirstName().equals(s2.getFirstName()))
            return s1.getLastName().compareTo(s2.getLastName());
        else
            return s1.getFirstName().compareTo(s2.getFirstName());
    }
}
