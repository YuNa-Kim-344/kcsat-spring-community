package hpclab.kcsatspringcommunity.admin.repository;

import hpclab.kcsatspringcommunity.admin.domain.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {

}
