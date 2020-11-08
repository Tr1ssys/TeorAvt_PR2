import java.util.*;


public class RegMatchBigLetter {

    public static final int START = 0;
    public static final int BigLettersST = 1;



    public static void main(String[] args) {
// Создаем список со специальными символами
        List<Character> BigLetters = new ArrayList<>();
        char BigLetter = 'A';
        while(BigLetter <='Я'){
            if ((BigLetter>='А'&&BigLetter<='Я')||
                    (BigLetter>='A'&&BigLetter<='Z')){
                BigLetters.add(BigLetter);
            }
            BigLetter++;
        }
// описываем состояния автомата
        Set<Integer> endStates = Collections.singleton(BigLettersST);
        StateMachine sm = new StateMachine(START, endStates);
        sm.add(START, BigLetters, BigLettersST);
        sm.add(BigLettersST, BigLetters, BigLettersST);


// Поиск всех вхождений в строке:
        String str;
        System.out.println("Введите строку: ");
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        sm.findAll(str);
        in.close();
    }
}