import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Student[] student = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            student[i] = new Student(name, kor, eng, mat);
        }
        Arrays.sort(student);
        for (int i = 0; i < n; i++) {
            System.out.println(student[i].name);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {
        if (this.kor != student.kor) {
            return student.kor - this.kor;
        }
        if (this.eng != student.eng) {
            return this.eng - student.eng;
        }
        if (this.math != student.math) {
            return student.math - this.math;
        }
        return this.name.compareTo(student.name);
    }
};