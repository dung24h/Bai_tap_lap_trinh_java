import java.io.*;
import java.util.*;

// 1. Định nghĩa Custom Exception (Yêu cầu 4)
class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super("Invalid config: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config: ");
        String filePath = sc.nextLine();

        BufferedReader reader = null;
        Map<String, String> configMap = new HashMap<>();

        try {
            // 2. Đọc file theo từng dòng (Yêu cầu 1)
            File configFile = new File(filePath);
            if (!configFile.exists()) {
                throw new FileNotFoundException("Config file not found.");
            }
            reader = new BufferedReader(new FileReader(configFile));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // 3. Tách theo dấu = (Yêu cầu 2)
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    configMap.put(key, value);
                }
            }

            // 4. Kiểm tra dữ liệu hợp lệ (Yêu cầu 3)
            validateConfig(configMap);

            // Nếu vượt qua validate mà không ném lỗi
            System.out.println("Config loaded successfully.");
            System.out.println("Nội dung cấu hình: " + configMap);

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error.");
            e.printStackTrace();
        } finally {
            // 5. Đảm bảo đóng file (Yêu cầu 5)
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 6. Luôn in thông báo kết thúc (Yêu cầu 6)
            System.out.println("Program finished.");
            sc.close();
        }
    }

    // Hàm kiểm tra logic cấu hình
    private static void validateConfig(Map<String, String> map) throws InvalidConfigException {
        // Kiểm tra bắt buộc phải có username và timeout
        if (!map.containsKey("username")) {
            throw new InvalidConfigException("Missing username");
        }
        if (!map.containsKey("timeout")) {
            throw new InvalidConfigException("Missing timeout");
        }

        // Kiểm tra timeout phải là số nguyên và > 0
        try {
            int timeout = Integer.parseInt(map.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("timeout must be > 0");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(); // Sẽ được catch ở hàm main
        }

        // Kiểm tra maxConnections nếu có thì phải >= 1
        if (map.containsKey("maxConnections")) {
            int maxConn = Integer.parseInt(map.get("maxConnections"));
            if (maxConn < 1) {
                throw new InvalidConfigException("maxConnections must be >= 1");
            }
        }
    }
}