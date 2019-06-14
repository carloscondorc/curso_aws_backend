package aws.mitocode.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import aws.mitocode.spring.model.FeedBack;
import aws.mitocode.spring.service.INotificacionSNS;

@Service
public class NotificacionSNSServiceImpl implements INotificacionSNS {
	
	private Logger logger = Logger.getLogger(NotificacionSNSServiceImpl.class);

	@Value("${topico.aws.sns}")
	private String ARN_TOPICO_PROCESA_FEEDBACK;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private AmazonSNSClient servicioSNS;

	public void enviarNotificacionSubscriptores(FeedBack feedback) {
		try {
			logger.info("ARN_TOPICO_PROCESA_FEEDBACK: " + ARN_TOPICO_PROCESA_FEEDBACK);

			logger.info("BIENVENIDO AL ENVIO SNS");
			
			PublishRequest publishRequest = new PublishRequest(ARN_TOPICO_PROCESA_FEEDBACK,
					mapper.writeValueAsString(feedback));
			
			PublishResult publishResult = servicioSNS.publish(publishRequest);
			
			logger.info("MessageId - " + publishResult.getMessageId());
		} catch (Exception e) {
			logger.error("Error al enviar mensaje a SNS", e);
		}
	}
}
