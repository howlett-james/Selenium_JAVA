package CoreJAVA.episode_12;

public class ThrowKeyword {
    public static void main(String[] args) /*throws Exception*/{

        System.out.println("ABC");
        try {
            throw new Exception("Logan Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        throw new Exception("Logan Exception");
        System.out.println("PQR");

        //when cell value is invalid in file handling system
        String Exec_Flag = "N";
        if(Exec_Flag.equals("N")){
            try {
                throw new Exception("Execution flag is NO Exception");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
