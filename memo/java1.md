# 参考資料

- [スッキリわかるJava入門 第4版 (スッキリわかる入門シリーズ) | 中山 清喬, 国本 大悟, 株式会社フレアリンク |本 | 通販 | Amazon](https://www.amazon.co.jp/%E3%82%B9%E3%83%83%E3%82%AD%E3%83%AA%E3%82%8F%E3%81%8B%E3%82%8BJava%E5%85%A5%E9%96%80-%E7%AC%AC4%E7%89%88-%E3%82%B9%E3%83%83%E3%82%AD%E3%83%AA%E3%82%8F%E3%81%8B%E3%82%8B%E5%85%A5%E9%96%80%E3%82%B7%E3%83%AA%E3%83%BC%E3%82%BA-%E4%B8%AD%E5%B1%B1-%E6%B8%85%E5%96%AC/dp/4295017930)

# 基本ルール

- 1ファイルにつき、1クラス
	- クラス名がそのままファイル名となる
- コード実行までの流れ
	- テキストファイルを書く（.java）
	- コンパイラでコンパイルされ、==バイトコード==で記述される==クラスファイル（.class）==になる
		- この時にソースコードの確認もする
	- ==インタプリタ==内の==JVM==で実行し出力される
- ファイルの中の構造
	- ファイル＞クラスブロック＞メソッドブロック
- `Java filename.java`で実行できる
	- 基本的には`javac File.java` で.classファイルに変換し、`java File`で実行できる
	- 日本語は文字コードでエラーが出るため、`javac -encoding UTF-8 File.java`でコンパイルしなければならない。
# Hello world

```Java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
```

# 変数宣言
## 型・記法

```Java
public class Hello {
    public static void main(String[] args) {
        byte biteNum = 1; // すごい小さい数字
        short shortnum = 1000; // 小さい数字
        int intNum = 25555; // 普通の数字。メイン
        long longNum = 1000000000; // すごい大きい数字

        float floatNum = 1.0f; // 小数点を含む数字
        double doubleNum = 1.0; // 小数点を含む数字。こっちがメイン

        char charNum = 'A'; // 1文字
        String stringNum = "Hello, World!"; // 文字列

        boolean boolNum = true; // true or false
    }
}

```

## 定数

```Java
public class Hello {
    public static void main(String[] args) {
        final String message = "Hello, World!"; // 定数の宣言
    }
}
```

# 文・式

## 基本ルール

- a=b+1のときは、==a,b,1がオペランド==・==+,=を演算子==と呼ぶ
- 5,"aaa"など==具体的な値をリテラル==と呼ぶ
- エスケープシーケンスの記法
	- \の文字で行う
- テキストブロック
	- """テキスト"""で表現
- Pythonのような演算子を使った型変換も可能
- ;で区切る

## 演算子

| 演算子    | 説明               |
| --------- | ------------------ |
| +         | 加算・文字列の結合 |
| -         | 減算               |
| *         | 乗算               |
| /         | 除算               |
| %         | 剰余               |
| (演算子)= | a+=b<br>→ a=a+b    |
| ++        | +1する             |
| --        | -1する             |


## よく使いそうな命令

| 命令文                                                       | 内容                                     |
| ------------------------------------------------------------ | ---------------------------------------- |
| `System.out.println(string:引数)`                            | 引数を表示する                           |
| `new java.util.Random().nestInt(int:引数)`                   | 引数0~引数までの値をランダムに表示する   |
| `new java.util.Scanner(System.in).nextLine()`<br>`new java.util.Scanner(System.in).nextInt()` | 実行を一時停止し、ユーザーの入力を求める |

### 注意

これだとメモリ解放がされずにエラーが出てしまう。
```Java
public class Hello {
    public static void main(String[] args) {
        String txt = new java.util.Scanner(System.in).nextLine();
        System.out.println("Hello, " + txt);

    }
}
```

そのためtryを使ってメモリ解放をしなければならない
```Java
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String txt = scanner.nextLine();
            System.out.println("Hello, " + txt);
        } // 自動的にscanner.close()が呼び出される
    }
}
```

# 制御構造

## 分岐

### if - else if - else文

```Java
public class Hello {
    public static void main(String[] args) {
        boolean result = false;
        boolean success = true;
        if (result) {
            System.out.println("Hello, World!");
        } else if (success) {
            System.out.println("Goodbye, World!");
        } else {
            System.out.println("No message");
        }
    }
}
```

### 三項演算子
```Java
public class Hello {
    public static void main(String[] args) {
        boolean result = false;
        String message = result ? "Hello, World!" : "Goodbye, World!"; // 三項演算子を使うときはvoid型にはできない
        System.out.println(message);
    }
}
```

### Switch文

```Java
//古い書き方

public class Hello {
    public static void main(String[] args) {
        String action = "eat";

        switch (action) {
            case "run":
                System.out.println("走る");
                break;
            case "eat":
                System.out.println("ご飯を食べる");
                break;
            case "sleep":
                System.out.println("寝る");
                break;
            default:
                System.out.println(action + "はありません");
                break;
        }
    }
}
```

```Java
// こっち推奨

public class Hello {
    public static void main(String[] args) {
        String action = "eat";

        switch (action) {
            case "run" -> {
                System.out.println("走る");
            }
            case "eat" -> {
                System.out.println("ご飯を食べる");
            }
            case "sleep" -> {
                System.out.println("寝る");
            }
            default -> {
                System.out.println(action + "はありません");
            }
        }
    }
}
```

```Java
//省略する書き方

public class Hello {
    public static void main(String[] args) {
        Integer action = 3;
        String txt = switch (action) {
            case 1 -> "走る";
            case 2 -> "御飯食べる";
            case 3 -> "寝る";
            default -> "何もしない";
        };
        System.out.println(txt);
    }
}
```
## 繰り返し

### for文

```Java
public class Hello {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello, World! " + i);
        }
    }
}
```
### while文

```Java
public class Hello {
    public static void main(String[] args) {
        int condition = 0;
        while (condition != 10) {
            System.out.println("Hello, World");
            condition++;
        }
    }
}
```

```Java
public class Hello {
    public static void main(String[] args) {
        int condition = 0;
        do {
            System.out.println("Hello, World");
            condition++;
        } while (condition != 10);
    }
}
```
### 演算子

| 演算子 | 意味           |
| ------ | -------------- |
| &&     | かつ           |
| \|\|   | または         |
| !条件  | 条件結果の反対 |

### 注意事項

- 文字の比較には`==`ではなく`比較元文字列.equals(比較先文字列)`を使う
- breakとcontinueで中断・継続を行う

# 配列
```Java
public class Hello {
    public static void main(String[] args) {
        int[] scores = new int[5]; // 5つの要素を持つ配列を作成
        scores[0] = 20; // 1つ目の要素に20を代入
        int num = scores.length; // 配列の数をカウント
        System.out.println(scores[0]);
        System.out.println(num);
    }
}
```
## 省略記号

```Java
public class Hello {
    public static void main(String[] args) {
        int[] scores1 = new int[] { 20, 30, 40, 50, 80 }; // 配列の宣言と初期化
        int[] scores2 = { 20, 30, 40, 50, 80 }; // 配列の宣言と初期化
        System.out.println(scores1[0]);
        System.out.println(scores2[3]);
    }
}
```

## 拡張for文

```Java
public class Hello {
    public static void main(String[] args) {
        int[] scores1 = new int[] { 20, 30, 40, 50, 80 }; // 配列の宣言と初期化
        for (int value : scores1) {
            System.out.println(value);
        }
    }
}
```

## 多次元の場合

```Java
public class Hello {
    public static void main(String[] args) {
        int[][] numbers = new int[3][4]; // 3x4 array
        numbers[0][0] = 1; // 0列目0行目
        numbers[0][1] = 2; // 0列目1行目
        numbers[1][0] = 3; // 1列目0行目
        System.out.println(numbers.length); // 3
        System.out.println(numbers[0].length); // 4
    }
}
```

# メソッド

```Java
public class Hello {
    public static void main(String[] args) {
        hello();
        goodby("Alice", 15); // void型のメソッドは、他のメソッドの引数に指定できない
        String result = eat("apple");
        String result2 = eat(3); // メソッド名が同じでも引数の型が違う場合は、別のメソッドとして扱われる（オーバーロード）
        String[] foods = { "apple", "banana", "orange" };
        System.out.println(result);
        System.out.println(result2);
        eatList(foods); // 配列を引数に指定する場合（参照渡し）

    }

    public static void hello() {
        System.out.println("Hello, World!");
    }

    public static void goodby(String name, int year) {
        System.out.println("goodby " + name);
        System.out.println(year + 20);
    }

    public static String eat(String food) { // 戻り値を文字型で帰す場合
        return "eat " + food;
    }

    public static String eat(int foodNum) { // 戻り値を文字型で帰す場合
        return "eat " + foodNum + " apples";
    }

    public static void eatList(String[] foods) {
        for (String food : foods) {
            System.out.println("eat " + food);
        }
    }
}
```

# コマンドライン変数の場合

`java Hello.java name`で起動した場合

```Java
public class Hello {
    public static void main(String[] args) {
        System.out.println(args[0]); //nameと表示
    }
}
```

# 複数ファイルに分割する場合

```
📦java
 ┣ 📂java1_mult
 ┃ ┣ 📜CalcLogic.class
 ┃ ┗ 📜CalcLogic.java
 ┣ 📜Calc.java
```

- 呼び出される側のJavaファイルはjavacでclassファイルを生成しておく必要がある？（未調査）

## Calc.java

```java
import java1_mult.CalcLogic;

public class Calc {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int total = CalcLogic.tasu(a, b);
        int delta = CalcLogic.hiku(a, b);
        System.out.println("tasu=" + total + " hiku=" + delta);

    }
}

```

## java1_mult/CalcLogic.java

```java
package java1_mult;

public class CalcLogic {
    public static int tasu(int a, int b) {
        return (a + b);
    }

    public static int hiku(int a, int b) {
        return (a - b);
    }
}

```

## ルール

- 同じフォルダ内ならモジュールの指定なく呼べる
- 別のフォルダの場合はパッケージとして名付ける必要がある？
- importで呼び出せなくてもファイル内で直接パスを指定して呼び出せる

# 主要な標準パッケージ

| `java.lang` | 基本的なクラス郡。import命令無しで呼べる。（Systemのように） |
| ----------- | ------------------------------------------------------------ |
| `java.util` | 便利なクラス群                                               |
| `java.math` | 数学系のクラス群                                             |
| `java.net`  | ネット接続系のクラス群                                       |
| `java.io`   | ファイル管理など、データ逐次維持処理のデータ群               |
