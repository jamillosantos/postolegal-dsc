package br.edu.ifrn.postolegal.service;

package br.edu.ifrn.postolegal.service;

import br.edu.ifrn.postolegal.PostoLegalApplication;
import br.edu.ifrn.postolegal.domain.Station;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = PostoLegalApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class })

/**
 *
 * @author renat
 */
public class StationServiceTest extends AbstractTestNGSpringContextTests{
    @Inject
    private StationService _station;
    
    private final String NAME_VALID = "nome 01";
    private final String LATITUDE_VALID = "654321";
    private final String LONGITUDE_VALID = "123456";
    
        @Test
    public void testSave_Success() throws Exception
    {
            this._service.save(Station.builder()
                    .name(NAME_VALID)
                    .build());
            this._service.save(Station.builder()
                    .latitude(LATITUDE_VALID)
                    .build());
            this._service.save(Station.builder()
                    .longitude(LONGITUDE_VALID)
                    .build());
    }
    
      // Name
    @Test(expectedExceptions = RequiredException.class)
    public void testSave_NameNull() throws Exception
    {
            this._service.save(Station.builder().build());
    }

    @Test(expectedExceptions = RequiredException.class)
    public void testSave_NameEmpty() throws Exception
    {
            this._service.save(Station.builder()
                    .name("")
                    .build());
    }

    @Test
    public void deleteOne() throws Exception
    {
            Station object = Station.builder()
                    .name(NAME_VALID)
                    .build();
            this._service.save(object);
            this._service.delete(object);
            assertThat(this._service.iterator().hasNext()).isFalse();
    }
    // [END] Name
    
    /////////////////////// Latitude
    @Test(expectedExceptions = RequiredException.class)
    public void testSave_LatitudeNull() throws Exception
    {
            this._service.save(Station.builder().build());
    }

    @Test(expectedExceptions = RequiredException.class)
    public void testSave_LatitudeEmpty() throws Exception
    {
            this._service.save(Station.builder()
                    .latitude("")
                    .build());
    }

    @Test
    public void deleteOne() throws Exception
    {
            Station object = Station.builder()
                    .latitude(LATITUDE_VALID)
                    .build();
            this._service.save(object);
            this._service.delete(object);
            assertThat(this._service.iterator().hasNext()).isFalse();
    }
    //////////////// [END] Latitude
    
    /////////////////////// Longitude
    @Test(expectedExceptions = RequiredException.class)
    public void testSave_LongitudeNull() throws Exception
    {
            this._service.save(Station.builder().build());
    }

    @Test(expectedExceptions = RequiredException.class)
    public void testSave_LongitudeEmpty() throws Exception
    {
            this._service.save(Station.builder()
                    .longitude("")
                    .build());
    }

    @Test
    public void deleteOne() throws Exception
    {
            Station object = Station.builder()
                    .longitude(LONGITUDE_VALID)
                    .build();
            this._service.save(object);
            this._service.delete(object);
            assertThat(this._service.iterator().hasNext()).isFalse();
    }
    //////////////// [END] longitude
}
