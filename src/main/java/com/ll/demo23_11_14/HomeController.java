package com.ll.demo23_11_14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
// 컨트롤러임
public class HomeController {
    int num = 0;

    @GetMapping("/")
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 출력하라는 의미
    String showMain() {
        System.out.println("안녕하세요!!");
        return "안녕하세요";
    }

    @GetMapping("/about")
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 출력하라는 의미
    String showAbout() {
        return "개발자 커뮤니티";
    }

    // http://localhost:8020/calc1?a=100&b=200
    @GetMapping("/calc1")
    @ResponseBody
    String showCalc1(int a, int b) {
        return "계산 결과 : %d".formatted(a + b);
    }

    // http://localhost:8020/calc2?a=100&b=200
    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b) {
        return "a : " + a + ", b : " + b;
    }


    // http://localhost:8020/calc3?a=100&b=200
    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b) {
        return "계산 결과 : %d".formatted(a + b);
    }

    // http://localhost:8020/calc4?a=10&b=10.5
    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b) {
        return "계산 결과 : %f".formatted(a + b);
    }

    // http://localhost:8020/calc5?a=10&b=10.5%EC%9E%85%EB%8B%88%EB%8B%A4
    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "0") String a,
            @RequestParam(defaultValue = "0") String b) {
        return "계산 결과 : %s".formatted(a + b);
    }

    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(
            int a, int b
    ) {
        return a + b;
    }

    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b
    ) {
        return a > b;
    }

    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ) {
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) {
        return new Person2(age, name);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) {
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );
        return personMap;
    }



    @GetMapping("/calc21")
    @ResponseBody
    int showCalc21() {
        num++;
        return num;
    }
}

@AllArgsConstructor
class Person {
    public String name;
    public int age;
}

@AllArgsConstructor
class Person2 {
    @Getter
    private int age;
    @Getter
    private String name;
}