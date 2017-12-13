import DataRepository.FakeDataRepository;
import DataRepository.IDataRepository;
import DataRepository.DataRepository;
import Units.Departure;
import Units.Room;
import Units.StudyUnit;
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
        dataRepository = new DataRepository();
        room = new Room(1,2,20,"desk,computer");
    }

    @Test
    public void RoomAndGetAllRooms_ResultShouldContainThatRoom() throws Exception{
        dataRepository.addRoom(room);
        rooms = dataRepository.getAllRooms();

        Assert.assertTrue(rooms.contains(room));
    }

    @Test(expected = Exception.class)
    public void TwoEqualRooms_ShouldThrowException() throws Exception{
        dataRepository.addRoom(room);
        dataRepository.addRoom(room);
    }

    @Test
    public void DepartureAndGetAllDepartures_ResultShouldContainThatDeparture() throws Exception {
        Departure departure = new Departure(1,"University");

        dataRepository.addDeparture(departure);
        departures = dataRepository.getAllDepartures();

        Assert.assertTrue(departures.contains(departure));
    }

    @Test(expected = Exception.class)
    public void GetDepartmentWithUnknownId_ShouldThrowException() throws Exception {
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
