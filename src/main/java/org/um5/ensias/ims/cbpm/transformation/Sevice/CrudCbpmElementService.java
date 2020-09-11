package org.um5.ensias.ims.cbpm.transformation.Sevice;

import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;
import org.um5.ensias.ims.cbpm.transformation.model.Event;
import org.um5.ensias.ims.cbpm.transformation.model.Gateway;
import org.um5.ensias.ims.cbpm.transformation.model.Service;

import java.util.List;
import java.util.Optional;

public interface CrudCbpmElementService {
    //generic

    List<CbpmElement> findAll();
    Optional<CbpmElement> findById(long id);
    void deleteById(long id);
    CbpmElement create(CbpmElement cbpmElement);
    CbpmElement update(CbpmElement cbpmElement);
    //Event

    List<Event> findAllEvent();
    Optional<Event> findEventById(long id);
    void deleteEventById(long id);
    Event createEvent(Event event);
    Event updateEvent(Event event);
    //Gateway


    List<Gateway> findAllGateway();
    Optional<Gateway> findGatewayById(long id);
    void deleteGatewayById(long id);
    Gateway createGateway(Gateway gateway);
    Gateway updateGateway(Gateway gateway);

    //Service


    List<Service> findAllService();
    Optional<Service> findServiceById(long id);
    void deleteServiceById(long id);
    Service createService(Service service);
    Service updateService(Service service);
}
