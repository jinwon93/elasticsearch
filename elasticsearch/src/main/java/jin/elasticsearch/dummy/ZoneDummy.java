package jin.elasticsearch.dummy;


import jin.elasticsearch.zone.Zone;
import jin.elasticsearch.zone.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ZoneDummy implements ApplicationRunner {

    private final ZoneRepository zoneRepository;

    public void run(ApplicationArguments args) throws Exception {
        zoneRepository.save(Zone.of("서울시" , "서초구"));
    }

}
