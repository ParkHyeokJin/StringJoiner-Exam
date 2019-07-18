# StringJoiner-Exam

### StringJoining.class and String.join()

���� ���ڿ� ���ͷ� �Ǵ� ��ü�� ���� �ϴ� ���� ���α׷��ֿ��� �Ϲ����� �䱸 �����̴�.
�������� JDK API������ ���� ���ڿ� ���ͷ� �Ǵ� ��ü�� ���� �ϴ� ����� ������ ������
������ ������ �ؾ� �ߴ�.  
�Ʒ��� ���� ����� �־����� ��츦 �����غ���.

- ��� 1 : {"hello", "java", "World"}�� ���ڿ� �迭�� �ִ�. �� ���ڿ� �迭�� " " �������� ���� �ϰ��� �Ѵ�.
  
> ��1) Joning.class
```java
public class Joning{
    String[] str = {"hello", "java", "World"};
    @Test
    public void vanillaJava() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) {
            sb.append(str[i]).append(" ");
        }
        assertEquals("hello java World", sb.toString());
    }
}
```
    
���ڿ� �迭�� ������ ���鼭 ���� �Ͽ���. ������ �� �ڵ�� ������ ����.  
"hello java World" �� ��� �Ͽ����� �������� " " �����ڰ� �������� ������ �߻� �Ͽ���.  
�׷��� �Ʒ��� ���� ������ �ε��������� �����ڸ� ������ �ʵ��� ������ �־���.  
    
```java
public class Joning{
    String[] str = {"hello", "java", "World"};
    @Test
    public void vanillaJava() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) {
            if(i == str.length-1) {
                sb.append(str[i]); 
                break;
            }
            sb.append(str[i]).append(" ");
        }
        assertEquals("hello java World", sb.toString());
    }
}
```
    
���� ������ �迭�� �����ϴ� ��������� String�� ���� �ϴ� �������� String, StringBuilder, StringBuffer��
����� ��� �ϴ��Ŀ� ���� ���� �޸𸮵� ����ؾ� �ϴ� �κе��� ���� �ϸ�
�� ���� ó�� �������� �߻� �� ������ ����.  
�̷� �������� JAVA8������ StringJonier.class �� String.Join() API�� �̿��ؼ� �ذ� �� �� �־�����.
    
### StringJoiner  
�־��� ����� �� ���1�� ������ �����̴�. StringJonier.class�� Ȱ���� �ҽ��� ����.

    ```java
    public class Joning{
        String[] str = {"hello", "java", "World"};
        @Test
        public void java8Joiner() {
            StringJoiner joiner = new StringJoiner(" ");
            for(int i = 0; i < str.length; i++) {
                joiner.add(str[i]);
            }
            assertEquals("hello java World", joiner.toString());
        }
    }
    ```    

������ ������� �׽�Ʈ�� ����ߴ�. ������ �ε����� ��� �ؾ� �� �ʿ䵵 ���� �޸𸮸� ��� �� �ʿ䵵 ����.  
    
- StringJoiner Constructor
    
```java
   public StringJoiner(CharSequence delimiter){}
   public StringJoiner(CharSequence delimiter,
                       CharSequence prefix,
                       CharSequence suffix){}
```
    
- add() Method
    
```java
public StringJoiner add(CharSequence newElement) {
        prepareBuilder().append(newElement);
        return this;
    }
 ```
     
> add �޼���� Builder �� �����Ǿ��־� �Ʒ��� ���� �����ؼ� ����� �����ϴ�.
    
```java
 new StringJoiner(" ").add("hello").add("java").add("World");
```
    
### String.Join()

JAVA8������ String Ŭ�������� Join �޼��带 ���� �ϰ� �ִ�.
    
    ```java
    public class Joning{
        String[] str = {"hello", "java", "World"};
        @Test
        public void java8StringJoin() {
                     assertEquals("hello java World", String.join(" ", str));
        }
    }
    ```
    
������ �̿��ؼ� ������ ����� ���� �� �ִ�.  
String.Join() �޼���� �Ʒ��� ���� ���������� StringJoiner() Ŭ������ �����ϰ� �մ�.
    
    - String.Join()
    ```java
    public static String join(CharSequence delimiter, CharSequence... elements) {
            Objects.requireNonNull(delimiter);
            Objects.requireNonNull(elements);
            // Number of elements not likely worth Arrays.stream overhead.
            StringJoiner joiner = new StringJoiner(delimiter);
            for (CharSequence cs: elements) {
                joiner.add(cs);
            }
            return joiner.toString();
        }
    ```
    
### ���
�̿ܿ��� Stream Collectors Ŭ������ joining()�� �̿��ؼ� ������ �� �� �� ������
�޼��� ���ο����� StringJonier Ŭ���� �� �̿��ؼ� ���� �Ǿ��ֱ� ������
StringJonier Ŭ������ ���� �ؼ� �˰� �ִ� ���� ���� �� ����.
    

    