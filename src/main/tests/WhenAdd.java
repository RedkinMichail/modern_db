import DataRepository.FakeDataRepository;
import DataRepository.IDataRepository;
import Units.Departure;
import Units.Room;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WhenAdd {
    private IDataRepository dataRepository;
    private ArrayList<Room> rooms;
    private ArrayList<Departure> departures;
    private Room room;
    @Before
    public void setUp(){
        dataRepository =  new FakeDataRepository();
        room = new Room(1,1,20,"desk,computer");
    }

    @Test
    public void RoomAndInvokeGetAllRooms_ResultShouldContainThatRoom(){
        dataRepository.addRoom(room);
        rooms = dataRepository.getAllRooms();

        Assert.assertTrue(rooms.contains(room));
    }

    @Test
    public void DepartureAndInvokeGetAllDepartures_ResultShouldContainThatDeparture() throws Exception {
        Departure departure = new Departure(1,"University");

        dataRepository.addDeparture(departure);
        departures = dataRepository.getAllDepartures();

        Assert.assertTrue(departures.contains(departure));
    }

    @Test(expected = Exception.class)
    public void InvokeGetDepartmentWithUnknownId_ShouldThrowException() throws Exception {
        dataRepository.getDepartureById(1);
    }

    @Test(expected = Exception.class)
    public void DepartureWithUnknownParentId_ShouldThrowException() throws Exception {
        Departure departure = new Departure(2,"ITMM", 2);

        dataRepository.addDeparture(departure);
    }

    @Test
    public void DepartureWithKnownParentId_ShouldAdded() throws Exception {
        Departure parentDeparture = new Departure(1,"University");
        Departure departure = new Departure(2,"ITMM", 1);

        dataRepository.addDeparture(parentDeparture);
        dataRepository.addDeparture(departure);

        assertEquals(dataRepository.getDepartureById(departure.getId()), departure);
    }


}
