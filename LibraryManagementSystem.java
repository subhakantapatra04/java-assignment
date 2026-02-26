import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSystem {

    static String url = "jdbc:mysql://localhost:3306/librarydb";
    static String user = "root";
    static String pass = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            while (true) {
                System.out.println("\n1 Add Book");
                System.out.println("2 View Books");
                System.out.println("3 Borrow Book");
                System.out.println("4 Return Book");
                System.out.println("5 Exit");

                int ch = sc.nextInt();

                if (ch == 1) {
                    sc.nextLine();
                    System.out.print("Book name: ");
                    String name = sc.nextLine();

                    PreparedStatement ps = con.prepareStatement(
                            "insert into books(name,status) values(?,?)");
                    ps.setString(1, name);
                    ps.setString(2, "available");
                    ps.executeUpdate();
                    System.out.println("Added");

                } else if (ch == 2) {

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from books");

                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                    }

                } else if (ch == 3) {

                    System.out.print("Book id: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                            "update books set status='borrowed' where id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    System.out.println("Borrowed");

                } else if (ch == 4) {

                    System.out.print("Book id: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                            "update books set status='available' where id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    System.out.println("Returned");

                } else if (ch == 5) {
                    break;
                }
            }

            con.close();

        } catch (Exception e) {
            System.out.println("DB Error");
        }
    }
}
