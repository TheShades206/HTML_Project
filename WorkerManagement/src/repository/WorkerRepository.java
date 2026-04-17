package repository;

import dto.SalaryHistoryResponseDTO;
import dto.WorkerRequestDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.SalaryHistory;
import model.Worker;

public class WorkerRepository {

    // Khai bao bien luu tru 
    private Map<String, Worker> workerMap = new HashMap<>();

    //Constructor
    public WorkerRepository() {
    }

    // Luu doi tuong Worker vao bien luu tru workerMap
    public void save(WorkerRequestDTO dto) {
        Worker worker = new Worker(dto.getId(), dto.getName(), dto.getAge(), dto.getSalary(), dto.getLocation());
        this.workerMap.put(worker.getId(), worker);
    }

    // Tra ve id cua Worker khi tim duoc trong workerMap
    public Worker findById(String workerId) {
        return this.workerMap.get(workerId);
    }

    // Kiem tra id da co san trong workerMap
    public boolean exists(String workerId) {
        return this.workerMap.containsKey(workerId);
    }

    // Kiem tra map co dang trong workerMap khong
    public boolean isEmpty() {
        return this.workerMap.isEmpty();
    }

    // Tra ve tat ca doi tuong Worker
    public List<Worker> findAll() {
        return new ArrayList<>(this.workerMap.values());
    }

    // Tra ve toan bo luong cua Worker
    public List<SalaryHistoryResponseDTO> getSalaryHistory() {
        List<SalaryHistoryResponseDTO> result = new ArrayList<>();

        // Duyet tung Worker trong map
        for (Worker w : this.workerMap.values()) {
            // duyet tung lich su giao dich
            for (SalaryHistory h : w.getHistory()) {
                result.add(new SalaryHistoryResponseDTO(
                        w.getId(), w.getName(), w.getAge(), h.getSalaryAfter(), h.getStatus().name(), h.getDate()
                ));
            }
        }

        return result;
    }
}
