package uk.gov.ons.ctp.response.action.export.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import uk.gov.ons.ctp.common.error.CTPException;
import uk.gov.ons.ctp.response.action.export.domain.ExportMessage;
import uk.gov.ons.ctp.response.action.export.service.impl.TransformationServiceImpl;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * To unit test TransformationServiceImpl
 */
@RunWith(MockitoJUnitRunner.class)
public class TransformationServiceImplTest {
  @InjectMocks
  private TransformationServiceImpl transformationService;

  /**
   * Tests processActionRequests if there is nothing to process.
   */
  @Test
  public void testProcessActionRequestsNothingToProcess() {
    try {
      ExportMessage sftpMessage = transformationService.processActionRequests(new ExportMessage(), new ArrayList<>());
      assertNotNull(sftpMessage);
      assertTrue(sftpMessage.getOutputStreams().isEmpty());
      assertTrue(sftpMessage.getActionRequestIds().isEmpty());
    } catch (CTPException e) {
      // CTPException ignored and empty Export message returned.
    }
  }

}