
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTasks {
    public static void main(String[] args){
        task1();
    }

    /**Дан массив названий переменных в camelCase. Преобразовать названия в snake_case*/
    static void task1(){
        String []strings={"blaCar","xMan","msDigits","onePunch","obiOne"};
        for (String s:strings
             ) {
            System.out.print(s+"\t");
        }
        String []newStrings=new String[strings.length];
        for (int i=0;i<strings.length;i++) {
            char[]arr=strings[i].toCharArray();
            newStrings[i]=new String("");
            for(int j=0;j<arr.length;j++){
                if(Character.isUpperCase(arr[j])==true)
                    newStrings[i]=newStrings[i]+"_"+Character.toLowerCase(arr[j]);
                else
                    newStrings[i]+=arr[j];
            }
        }
        System.out.println("");
        for (String s:newStrings
             ) {
            System.out.print(s+"\t");
        }
    }

    /**Замените в строке все вхождения 'word' на 'letter'*/
    static void task2(){
        String s=new String("word, bla bla; wordword car , word history");
        System.out.println(s);
        s=s.replace("word","letter");
        System.out.println(s);
    }

    /**В строке найти количество цифр*/
    static void task3(){
        String s=new String("1if some83; the 21 pilots, to do the 6 a.m., 12 eggs, 17 ice creams");
        System.out.println(s);
        char []arr=s.toCharArray();
        int count=0;
        for(int i=0;i<arr.length;i++)
            if(Character.isDigit(arr[i])==true)
                count++;
        System.out.println("В строке "+count+" цифр");
    }

    /**В строке найти количество чисел*/
    static void task4(){
        String s=new String("12 15 bla 1 blabla bla ; 123 17 bla; 22 4.");
        System.out.println(s);
        char []arr=s.toCharArray();
        int count=0;
        for(int i=0;i<arr.length;i++)
            if(Character.isDigit(arr[i])==true) {
                while (Character.isDigit(arr[i]) == true)
                    i++;
                count++;
        }
        System.out.println("Количество чисел: "+count);
    }

    /**Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
     Крайние пробелы в строке удалить*/
    static void task5() {
        String s = new String("1    2 3;        4   5,      6      7    8");
        System.out.println(s);
        char[] arr = s.toCharArray();
        String newstring = new String("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==' ') {
                newstring+=arr[i];
                while (arr[i]==' ')
                    i++;
            }
            newstring+=arr[i];
        }
        s=newstring;
        System.out.println(s);
    }

    /*----------------------------------------------------------------------------------------*/

    /** Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем*/
    static void task11(){
        String s=new String("1  2   3        4              5        5        3  2;;;111");
        System.out.println(s);
        char []arr=s.toCharArray();
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==' '){
                int count=0;
                while(arr[i]==' '){
                    count++;
                    i++;
                }
                if (count>max)
                    max=count;
            }
        }
        System.out.println("Максимальное число пробелов: "+max);
    }

    /**В строке вставить после каждого символа 'a' символ 'b'*/
    static void task22(){
        String s=new String("aaaa 123 bbb a a a;;; aa22a");
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            int ind=sb.indexOf("a",i);
            sb.insert(ind+1,"b");
            i=ind+1;
        }
        s=sb.toString();
        System.out.println(s);
    }

    /**Проверить, является ли заданное слово палиндромом*/
    static void task33(){
        String s=new String("шалаш");
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        String s1=sb.toString();
        if(s.equals(s1))
            System.out.println("Слово - палиндром");
        else
            System.out.println("Слово - не палиндром");
    }

    /**С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”*/
    static void task44(){
        String s1="информатика";
        String s2=new String();
        char []arr=new char[1];
        int i;
        StringBuilder sb=new StringBuilder(s1);
        i=sb.indexOf("т");
        sb.getChars(i,i+1,arr,0);
        s2+=arr[0];
        i=sb.indexOf("о");
        sb.getChars(i,i+1,arr,0);
        s2+=arr[0];
        i=sb.indexOf("р");
        sb.getChars(i,i+1,arr,0);
        s2+=arr[0];
        i=sb.indexOf("т");
        sb.getChars(i,i+1,arr,0);
        s2+=arr[0];
        System.out.println(s2);
    }

    /**Подсчитать, сколько раз среди символов заданной строки встречается буква “а”*/
    static void task55(){
        String s="aa 123 aaaa 222 aaaaaaa            31313 a";
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        int count=0;
        for(int i=0;i<sb.length();i++){
            int ind=sb.indexOf("a",i);
            i=ind;
            count++;
        }
        System.out.println("буква а встечается "+count +" раз");
    }

    /**Из заданной строки получить новую, повторив каждый символ дважды*/
    static void task66(){
        String s="1 2 3 4 5 6 7";
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char c=sb.charAt(2*i);
            sb.insert(2*i,c);
        }
        s=sb.toString();
        System.out.println(s);
    }

    /** Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
     *def", то должно быть выведено "abcdef".*/
    static void task77(){
        String s="abc cde defaaa ggghh hhbb b123bb ccdd zz axy";
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(c==' ')
                sb.deleteCharAt(i--);
            else
                for(int j=i+1;j<sb.length();j++)
                    if(sb.charAt(j)==c)
                        sb.deleteCharAt(j--);
        }
        s=sb.toString();
        System.out.println(s);
    }

    /**Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
     *длинных слов может быть несколько, не обрабатывать*/
    static void task88(){
        String s="a aa aaa bbb ccccc aaaa cc bb zzzzzzzzzz";
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        String max="";
        for(int i=0;i<sb.length();i++){
            int ind=sb.indexOf(" ",i);
            String temp;
            if(ind!=-1)
                temp=sb.substring(i,ind);
            else
                temp=sb.substring(i,sb.length());

            if(temp.length()>max.length())
                max=temp;
            if(ind!=-1)
                i=ind;
        }
        System.out.println("Самое длинное слово: "+max);
    }

    /**Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только
     * английские буквы*/
    static void task99(){
        String s="a;b а П AA zYYYY Борис CC   dd EE";
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        int low=0;
        int high=0;
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(Character.isUpperCase(c) && c>=65 && c<=90)
                high++;
            if(Character.isLowerCase(c) && c>=97 && c<=122)
                low++;
        }
        System.out.println("Строчных английских - "+high+"; прописных английских - "+low);
    }

    /**Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
     * знаком. Определить количество предложений в строке X*/
    static void task1010(){
        String s="На поле танки грохотали. Но я хотела бы жить на Манхэттэне! А он просто диджей на радио?";
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        int count=0;
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(c=='.' || c=='!' || c=='?')
                count++;
        }
        System.out.println("Количество предложений в тексте: "+count);
    }

    /*----------------------------------------------------------------------------------------*/

    /**Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
     * операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
     * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
     * алфавиту*/
    static void task111(){
        String text=new String("Завтра будет завтра. А сегодня есть сегодня! Какое вино будем пить? Дай закурить.\n");
        text+="Кто бы что не говорил, Дмитрий Валерьевич сам себя не уволит! Шли бы вы отсюда. Грубовато вышло?\n";
        text+="Девушка, что вы завтр делаете вечером? А послезавтра?";

        System.out.println(text+"\n");
        System.out.println("1 - сортировать абзацы по количеству предложений");
        System.out.println("2 - сортировка слов в предложениях по длине");
        System.out.println("3 - сортировка лексем в предложении по убыванию количества вхождений символа 'а'\n");

        Scanner s=new Scanner(System.in);
        int c=s.nextInt();
        switch (c){
            case(1):
                text=sortParagraphs(text);
                break;
            case(2):
                text=sortWords(text);
                break;
            case(3):
                text=sortLexA(text);
                break;
        }

        System.out.println(text);

    }

    /**сортировка абзацев по возрастанию*/
    static private String sortParagraphs(String text){
        Pattern p= Pattern.compile("\\n");
        Matcher m=p.matcher(text);
        String []par=p.split(text);
        for(int i=0;i<par.length;i++){
            String []sent=par[i].split("[.!?]");//получили предложения в абзаце
            int min=i;
            for(int j=i+1;j<par.length;j++){
                if(par[j].split("[.!?]").length<par[min].split("[.!?]").length)
                    min=j;
            }
            if(min!=i){
                swapStrings(par,i,min);
            }
        }
        text="";
        for(int i=0;i<par.length;i++)
            text+=par[i]+"\n";
        return text;
    }

    /**сортировка слов в предложениях по длине*/
    static private String sortWords(String text){
        Pattern p= Pattern.compile("\\n");
        Matcher m=p.matcher(text);
        String []par=p.split(text);
        int wordStart=0;
        int wordEnd=0;
        for(int i=0;i<par.length;i++){
            String []sent=par[i].split("[.!?]");//получили предложения в абзаце
            for(int j=0;j<sent.length;j++){
                String []words=sent[j].split("[,;:.!?\\s]+");//получили слова в предложении
                for(int l=0;l<words.length;l++){
                    if(words[l].length()==0)
                        continue;;
                    int min=l;
                    int minStart=-1;
                    int minEnd=-1;
                    p=Pattern.compile(words[l]);
                    m=p.matcher(text);
                    m.find(wordStart);
                    wordStart=m.start();
                    wordEnd=m.end();
                    for(int k=l+1;k<words.length;k++){
                        if(words[k].length()<words[min].length()) {
                            min = k;
                            p=Pattern.compile(words[k]);
                            m=p.matcher(text);
                            m.find(wordStart);
                            minStart=m.start();
                            minEnd=m.end();
                        }
                    }
                    if(min!=l){
                        text=swapWordsInText(text,wordStart,wordEnd,minStart,minEnd);
                        wordStart =wordStart+ minEnd-minStart;
                        swapStrings(words,min,l);
                    }
                    else
                        wordStart+=words[l].length();
                }
            }

        }
        return text;
    }

    /**сортировка слов в предложениях по количеству 'а' или 'А' в слове*/
    static private String sortLexA(String text){
        Pattern p= Pattern.compile("\\n");
        Matcher m=p.matcher(text);
        String []par=p.split(text);
        int wordStart=0;
        int wordEnd=0;
        int [] numOfA;
        for(int i=0;i<par.length;i++){
            String []sent=par[i].split("[.!?]");//получили предложения в абзаце
            for(int j=0;j<sent.length;j++){
                String []words=sent[j].split("[,;:.!?\\s]+");//получили слова в предложении
                for(int l=0;l<words.length;l++){
                    if(words[l].length()==0)
                        continue;;
                    int max=l;
                    int maxStart=-1;
                    int maxEnd=-1;
                    p=Pattern.compile(words[l]);
                    m=p.matcher(text);
                    m.find(wordStart);
                    wordStart=m.start();
                    wordEnd=m.end();
                    for(int k=l+1;k<words.length;k++){
                        if(countA(words[k])>countA(words[max])){//сравнение на количество а в слове
                            max = k;
                            p=Pattern.compile(words[k]);
                            m=p.matcher(text);
                            m.find(wordStart);
                            maxStart=m.start();
                            maxEnd=m.end();
                        }
                        else
                            if(countA(words[k])==countA(words[max])){//если равно, то сортируем по алфавиту
                                if(words[k].compareTo(words[max])<0)
                                {
                                    max = k;
                                    p=Pattern.compile(words[k]);
                                    m=p.matcher(text);
                                    m.find(wordStart);
                                    maxStart=m.start();
                                    maxEnd=m.end();
                                }
                            }
                    }
                    if(max!=l){
                        text=swapWordsInText(text,wordStart,wordEnd,maxStart,maxEnd);
                        wordStart =wordStart+ maxEnd-maxStart;
                        swapStrings(words,max,l);
                    }
                    else
                        wordStart+=words[l].length();
                }
            }

        }
        return text;
    }

    /**подсчет колиество а или А в слове*/
    static private int countA(String s){
        int count=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++)
            if(arr[i]=='а' || arr[i]=='А')
                count++;
        return count;
    }

    /**свап слов в строке*/
    static private String swapWordsInText(String s, int a, int b, int c, int d) {
        String s1=s.substring(0,a);
        String s2=s.substring(a,b);
        String s3=s.substring(b,c);
        String s4=s.substring(c,d);
        String s5=s.substring(d,s.length());
        String res=s1+s4+s3+s2+s5;
        return res;
    }

    /**свап элементов в массиве строк*/
    static private void swapStrings(String []par,int i, int j){
        String temp=par[i];
        par[i]=par[j];
        par[j]=temp;
    }

}
