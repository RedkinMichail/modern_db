import DataRepository.FakeDataRepository;
import DataRepository.IDataRepository;
import Units.Room;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class WhenAdd {
    private IDataRepository dataRepository;
    private ArrayList<Room> rooms;
    private Room room;
    @Before
    public void setUp(){
        dataRepository =  new FakeDataRepository();
        String[] equipments = {"desk", "computer"};
        Room room = new Room(1,1,20,equipments);
        ArrayList rooms;
    }

    @Test
    public void RoomAndInvokeGetAllRooms_ResultContainThatRoom(){
        dataRepository.addRoom(room);
        rooms = dataRepository.getAllRooms();

        Assert.assertTrue(rooms.contains(room));
    }
}
