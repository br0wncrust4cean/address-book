package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddy", path="buddy")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    @RequestMapping("/findall")
    List<BuddyInfo> findByName(@Param("name") String name);

}
