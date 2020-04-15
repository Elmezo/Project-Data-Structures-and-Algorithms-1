
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DataStructureProject {

    public static void main(String[] args) throws MalformedURLException, IOException {
        Scanner s = new Scanner(System.in);
        Node root;
        System.out.println("Hi Welcom to my 'Data Structures and Algorithms' Project\n"
                + "First you should Enter the URL of your file 'txt' like an Ex :\n"
                + "C:/Users/abdo%20alaa/Desktop/dictionary.txt\n"
                + "this EX is a file in my Desktop\n"
                + "so if you don not know ho to get it you shout open your file by the bwroser and get the Url from the Bwroser ☻");
        String url_Locathion = s.next();
        URL url = new URL("file:///" + url_Locathion);

        try (BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            String i;
            root = new Node(i = read.readLine());
            while ((i = read.readLine()) != null) {
                Methods.insert(root, i);
            }
        }

        boolean test = true;
        while (test) {
            System.out.println();
            System.out.println("Please Enter your choise : ");
            System.out.println("1. Print tree using inorder traversal\n"
                    + "2. Print tree using postorder traversal\n"
                    + "3. Print tree using preorder traversal\n"
                    + "4. Print tree size (number of words loaded in the tree)\n"
                    + "5. Print tree using BFS Traversal\n"
                    + "6. Print tree height\n"
                    + "7. Search for a word\n"
                    + "8.Insert new word in the tree\n"
                    + "0.Exit");
            String chois = s.next();

            switch (chois) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Print using inorder");
                    Methods.inorder(root);
                    break;
                case "2":
                    System.out.println("Print using postorder");
                    Methods.postorder(root);
                    break;
                case "3":
                    System.out.println("Print using preorder");
                    Methods.preorder(root);
                    break;
                case "4":
                    System.out.println("The size of binary tree is : " + Methods.size(root));
                    break;
                case "5":
                    System.out.println("Print tree using BFS Traversal... ");
                    Methods.BFS(root);
                    break;
                case "6":
                    System.out.println("Height of tree is : " + Methods.height(root));
                    break;
                case "7":

                    System.out.println("Please Enter the Word");
                    String searchWord = s.next();

                    if (Methods.search_test(searchWord, root) == false) {
                        System.out.println("the word is correct.");
                        break;
                    } else {
                        Search_Method(root, searchWord);
                    }

                    break;
                case "8":
                    System.out.println("Please Enter the Word");
                    String insertWord = s.next();
                    if (Methods.search_test(insertWord, root) == false) {
                        System.out.println("This word is Already exist ♣");
                    } else {
                        Methods.insert(root, insertWord);
                        System.out.println("Done...♥");
                    }
                    break;
                default:
                    System.out.println("Rong Chois Please Try again ♥:)");

            }

        }

    }

    public static void Search_Method(Node root, String word) {

        System.out.println("Can not find the word  that is some suggestions .");

        Methods.printLastNode(word, root);

        Methods.printPreSuc(root, word);

    }

}
