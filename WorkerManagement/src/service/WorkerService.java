package service;

import constants.Message;
import constants.SalaryStatus;
import dto.WorkerRequestDTO;
import dto.SalaryHistoryResponseDTO;
import java.time.LocalDate;
import java.util.List;
import model.SalaryHistory;
import model.Worker;
import repository.WorkerRepository;
import java.util.Objects;

public class WorkerService {
    
    // Khai bao repository 
    private WorkerRepository repository = new WorkerRepository();
    
    //Constructor
    public WorkerService() {}
    
    // Chuyen lenh luu nhan vien xuong map
    public void addWorker(WorkerRequestDTO dto) {
        this.repository.save(dto);
    }
    
    // Goi ham update chung voi isIncrease = true
    public void increaseSalary(String workerId, double amount) throws Exception {
        this.updateSalary(workerId, amount, true);
    }
    
    // Goi ham update chung voi isIncrease = false
    public void decreaseSalary(String workerId, double amount) throws Exception {
        this.updateSalary(workerId, amount, false);
    }
    
    // Ham xu ly logic cong tru luong
    private void updateSalary(String workerId, double amount, boolean isIncrease) throws Exception {
        // Lay doi tuong nhan vien tu kho
        Worker worker = this.repository.findById(workerId);
        
        // Bao loi neu khong tim thay ID
        if(Objects.isNull(worker)) {
            throw new Exception("Worker does not exist!");
        }
        // Bao loi neu nhap so tien am
        else if(amount < 0) {
            throw new Exception(Message.POSITIVE_VALUE);
        }
        else {
            double currentSalary = worker.getCurrentSalary();
            double newSalary;
            
            // Tinh toan muc luong moi
            if(isIncrease) {
                newSalary = currentSalary + amount;
            } else {
                newSalary = currentSalary - amount ;
                // Chan loi neu tru luong rot xuong duoi 0
                if(newSalary < 0) {
                    throw new Exception(Message.POSITIVE_VALUE);
                }
            }
            
            // Cap nhat luong cua nhan vien
            worker.setCurrentSalary(newSalary);
            
            // Xac dinh trang thai 
            SalaryStatus status = isIncrease ? SalaryStatus.UP : SalaryStatus.DOWN;
            
            // Khoi tao lich su giao dich va cat vao ho so nhan vien
            worker.addHistory(new SalaryHistory(newSalary, status, LocalDate.now()));
        }
    }
    
    // Lay danh sach lich su de giao cho Controller
    public List<SalaryHistoryResponseDTO> getSalaryHistory() {
        return this.repository.getSalaryHistory();
    }
    
    // Kiem tra id trung lap
    public boolean isDuplicateCode(String code) {
        return this.repository.exists(code);
    }
    
    // Kiem tra kho co rong khong
    public boolean isEmpty() {
        return this.repository.isEmpty();
    }
}