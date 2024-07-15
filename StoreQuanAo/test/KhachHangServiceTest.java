package Service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.PowerMockInternalException;

import model.KhachHang;
import repository.DBConnect;
import Service.KhachHangService;
import java.util.ArrayList;
import java.util.List;


@PrepareForTest({ DBConnect.class })
public class KhachHangServiceTest {

    private KhachHangService khachHangService;

    @Mock
    private Connection mockConnection;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        khachHangService = new KhachHangService();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddData_Success() throws SQLException {
        KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
        Connection mockConnection = mock(Connection.class);
        when(DBConnect.getConnection()).thenReturn(mockConnection);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        boolean result = khachHangService.addData(kh);
        assertTrue(result);
    }

     @Test
    public void testUpdateData() throws Exception {
        KhachHang kh = new KhachHang("John Wick", "124 Main St", "123456789", "john.wick@example.com");
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        mockStatic(DBConnect.class);
        when(DBConnect.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        boolean result = khachHangService.updateData(kh);
        assertTrue(result);
        verify(mockPreparedStatement).setString(1, kh.getHoTen());
        verify(mockPreparedStatement).setString(2, kh.getDiaChi());
        verify(mockPreparedStatement).setString(3, kh.getGmail());
        verify(mockPreparedStatement).setString(4, kh.getSoDienThoai());
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    public void testUpdateDataMua() throws SQLException {
        // Prepare test data
        KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
        kh.setKhachHangId(1);
        kh.setSolanmuahang(5);
        kh.setTonggiatridamua(1000);
        Connection realConnection = DBConnect.getConnection();
        PreparedStatement realPreparedStatement = realConnection.prepareStatement("update KhachHang set SoLanMuaHang = ?, TongGiaTriDaMua = ? where KhachHangId = ?");
        doReturn(1).when(realPreparedStatement).executeUpdate();
        when(DBConnect.getConnection()).thenReturn(realConnection);
        boolean result = khachHangService.updateDataMua(kh);
        assertTrue(result);
    }

    @Test
    public void testFindDataKhachHang() throws SQLException {
        String sdt = "123456789";
        KhachHang expectedKhachHang = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
        Connection realConnection = DBConnect.getConnection();
        PreparedStatement realPreparedStatement = realConnection.prepareStatement("select * from KhachHang where SoDienThoai like ?");
        ResultSet realResultSet = realPreparedStatement.executeQuery();
        if (realResultSet.next()) {
            expectedKhachHang.setHoTen(realResultSet.getString("HoTen"));
            expectedKhachHang.setDiaChi(realResultSet.getString("DiaChi"));
            expectedKhachHang.setKhachHangId(realResultSet.getInt("KhachHangId"));
            expectedKhachHang.setDiaChi(realResultSet.getString("DiaChi"));
            expectedKhachHang.setSoDienThoai(realResultSet.getString("SoDienThoai"));
            expectedKhachHang.setSolanmuahang(realResultSet.getInt("SoLanMuaHang"));
            expectedKhachHang.setGmail(realResultSet.getString("Gmail"));
            expectedKhachHang.setTonggiatridamua(realResultSet.getFloat("TongGiaTriDaMua"));
        }
        when(DBConnect.getConnection()).thenReturn(realConnection);

        KhachHang resultKhachHang = khachHangService.findDataKhachHang(sdt);

        assertNotNull(resultKhachHang);
        assertEquals(expectedKhachHang.getHoTen(), resultKhachHang.getHoTen());
        assertEquals(expectedKhachHang.getDiaChi(), resultKhachHang.getDiaChi());
        assertEquals(expectedKhachHang.getKhachHangId(), resultKhachHang.getKhachHangId());
        assertEquals(expectedKhachHang.getSoDienThoai(), resultKhachHang.getSoDienThoai());
        assertEquals(expectedKhachHang.getSolanmuahang(), resultKhachHang.getSolanmuahang());
        assertEquals(expectedKhachHang.getGmail(), resultKhachHang.getGmail());
        assertEquals(expectedKhachHang.getTonggiatridamua(), resultKhachHang.getTonggiatridamua(), 0.001); // Float comparison

    }

    @Test
    public void testGetAllDataKhachHang() throws SQLException {
        List<KhachHang> expectedList = new ArrayList<>();
        KhachHang kh1 = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
        kh1.setKhachHangId(1);
        kh1.setSolanmuahang(5);
        kh1.setTonggiatridamua(1000);
        expectedList.add(kh1);

        KhachHang kh2 = new KhachHang("Jane Doe", "456 Elm St", "987654321", "jane.doe@example.com");
        kh2.setKhachHangId(2);
        kh2.setSolanmuahang(3);
        kh2.setTonggiatridamua(500);
        expectedList.add(kh2);

        Connection realConnection = DBConnect.getConnection();

        PreparedStatement realPreparedStatement = realConnection.prepareStatement("select * from KhachHang");
        ResultSet realResultSet = realPreparedStatement.executeQuery();
        while (realResultSet.next()) {
            KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
            kh.setHoTen(realResultSet.getString("HoTen"));
            kh.setDiaChi(realResultSet.getString("DiaChi"));
            kh.setKhachHangId(realResultSet.getInt("KhachHangId"));
            kh.setDiaChi(realResultSet.getString("DiaChi"));
            kh.setSoDienThoai(realResultSet.getString("SoDienThoai"));
            kh.setSolanmuahang(realResultSet.getInt("SoLanMuaHang"));
            kh.setGmail(realResultSet.getString("Gmail"));
            kh.setTonggiatridamua(realResultSet.getFloat("TongGiaTriDaMua"));
            expectedList.add(kh);
        }
        when(DBConnect.getConnection()).thenReturn(realConnection);
        List<KhachHang> resultList = khachHangService.getAllDataKhachHang();
        assertNotNull(resultList);
        assertEquals(expectedList.size(), resultList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            KhachHang expectedKhachHang = expectedList.get(i);
            KhachHang resultKhachHang = resultList.get(i);
            assertEquals(expectedKhachHang.getHoTen(), resultKhachHang.getHoTen());
            assertEquals(expectedKhachHang.getDiaChi(), resultKhachHang.getDiaChi());
            assertEquals(expectedKhachHang.getKhachHangId(), resultKhachHang.getKhachHangId());
            assertEquals(expectedKhachHang.getSoDienThoai(), resultKhachHang.getSoDienThoai());
            assertEquals(expectedKhachHang.getSolanmuahang(), resultKhachHang.getSolanmuahang());
            assertEquals(expectedKhachHang.getGmail(), resultKhachHang.getGmail());
            assertEquals(expectedKhachHang.getTonggiatridamua(), resultKhachHang.getTonggiatridamua(), 0.001); // Float comparison
        }

    }

    @Test
    public void testGetAllDataKhachHangFollowHoTenSDT() throws SQLException {
        String payload = "John";
        List<KhachHang> expectedList = new ArrayList<>();
        KhachHang kh1 = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
        kh1.setKhachHangId(1);
        kh1.setSolanmuahang(5);
        kh1.setTonggiatridamua(1000);
        expectedList.add(kh1);

        Connection realConnection = DBConnect.getConnection();

        PreparedStatement realPreparedStatement = realConnection.prepareStatement("select * from KhachHang where SoDienThoai = ? or HoTen like ? or Gmail = ?");
        realPreparedStatement.setObject(1, payload);
        realPreparedStatement.setObject(2, "%" + payload + "%");
        realPreparedStatement.setObject(3, payload);
        ResultSet realResultSet = realPreparedStatement.executeQuery();
        while (realResultSet.next()) {
            KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
            kh.setHoTen(realResultSet.getString("HoTen"));
            kh.setDiaChi(realResultSet.getString("DiaChi"));
            kh.setKhachHangId(realResultSet.getInt("KhachHangId"));
            kh.setDiaChi(realResultSet.getString("DiaChi"));
            kh.setSoDienThoai(realResultSet.getString("SoDienThoai"));
            kh.setSolanmuahang(realResultSet.getInt("SoLanMuaHang"));
            kh.setGmail(realResultSet.getString("Gmail"));
            kh.setTonggiatridamua(realResultSet.getFloat("TongGiaTriDaMua"));
            expectedList.add(kh);
        }
        when(DBConnect.getConnection()).thenReturn(realConnection);
        List<KhachHang> resultList = khachHangService.getAllDataKhachHangFollowHoTenSDT(payload);
        assertNotNull(resultList);
        assertEquals(expectedList.size(), resultList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            KhachHang expectedKhachHang = expectedList.get(i);
            KhachHang resultKhachHang = resultList.get(i);
            assertEquals(expectedKhachHang.getHoTen(), resultKhachHang.getHoTen());
            assertEquals(expectedKhachHang.getDiaChi(), resultKhachHang.getDiaChi());
            assertEquals(expectedKhachHang.getKhachHangId(), resultKhachHang.getKhachHangId());
            assertEquals(expectedKhachHang.getSoDienThoai(), resultKhachHang.getSoDienThoai());
            assertEquals(expectedKhachHang.getSolanmuahang(), resultKhachHang.getSolanmuahang());
            assertEquals(expectedKhachHang.getGmail(), resultKhachHang.getGmail());
            assertEquals(expectedKhachHang.getTonggiatridamua(), resultKhachHang.getTonggiatridamua(), 0.001); // Float comparison
        }
    }

    @Test
    public void testGetAllDataKhachHangFollowSoLanMuaHang() throws SQLException {

        int payload = 3;
        List<KhachHang> expectedList = new ArrayList<>();
        KhachHang kh1 = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
        kh1.setKhachHangId(1);
        kh1.setSolanmuahang(5);
        kh1.setTonggiatridamua(1000);
        expectedList.add(kh1);

        KhachHang kh2 = new KhachHang("Jane Doe", "456 Elm St", "987654321", "jane.doe@example.com");
        kh2.setKhachHangId(2);
        kh2.setSolanmuahang(3);
        kh2.setTonggiatridamua(500);
        expectedList.add(kh2);

        Connection realConnection = DBConnect.getConnection();

        PreparedStatement realPreparedStatement = realConnection.prepareStatement("select * from KhachHang where SoLanMuaHang >= ?");
        realPreparedStatement.setObject(1, payload);
        ResultSet realResultSet = realPreparedStatement.executeQuery();

        while (realResultSet.next()) {
            KhachHang kh = new KhachHang("John Doe", "123 Main St", "123456789", "john.doe@example.com");
            kh.setHoTen(realResultSet.getString("HoTen"));
            kh.setDiaChi(realResultSet.getString("DiaChi"));
            kh.setKhachHangId(realResultSet.getInt("KhachHangId"));
            kh.setDiaChi(realResultSet.getString("DiaChi"));
            kh.setSoDienThoai(realResultSet.getString("SoDienThoai"));
            kh.setSolanmuahang(realResultSet.getInt("SoLanMuaHang"));
            kh.setGmail(realResultSet.getString("Gmail"));
            kh.setTonggiatridamua(realResultSet.getFloat("TongGiaTriDaMua"));
            expectedList.add(kh);
        }

        when(DBConnect.getConnection()).thenReturn(realConnection);

        List<KhachHang> resultList = khachHangService.getAllDataKhachHangFollowSoLanMuaHang(payload);

        assertNotNull(resultList);
        assertEquals(expectedList.size(), resultList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            KhachHang expectedKhachHang = expectedList.get(i);
            KhachHang resultKhachHang = resultList.get(i);
            assertEquals(expectedKhachHang.getHoTen(), resultKhachHang.getHoTen());
            assertEquals(expectedKhachHang.getDiaChi(), resultKhachHang.getDiaChi());
            assertEquals(expectedKhachHang.getKhachHangId(), resultKhachHang.getKhachHangId());
            assertEquals(expectedKhachHang.getSoDienThoai(), resultKhachHang.getSoDienThoai());
            assertEquals(expectedKhachHang.getSolanmuahang(), resultKhachHang.getSolanmuahang());
            assertEquals(expectedKhachHang.getGmail(), resultKhachHang.getGmail());
            assertEquals(expectedKhachHang.getTonggiatridamua(), resultKhachHang.getTonggiatridamua(), 0.001); // Float comparison
        }
    }

}
