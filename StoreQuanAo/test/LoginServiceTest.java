/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NguoiDung;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import repository.DBConnect;

/**
 *
 * @author ADMIN
 */
public class LoginServiceTest {

    public LoginServiceTest() {
    }

    @Test
    public void testGetDataLogin() throws SQLException {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);
        when(rs.next()).thenReturn(true).thenReturn(false); // Simulate two records
        when(rs.getString("NguoiDungId")).thenReturn("1"); // Sample data
        when(rs.getString("HoTen")).thenReturn("John Doe"); // Sample data
        when(rs.getString("MatKhau")).thenReturn("password"); // Sample data
        when(rs.getString("TenQuyen")).thenReturn("Admin"); // Sample data
        when(rs.getBoolean("GioiTinh")).thenReturn(true); // Sample data
        when(rs.getString("DiaChi")).thenReturn("123 Main St"); // Sample data
        when(rs.getString("Email")).thenReturn("john.doe@example.com"); // Sample data
        when(rs.getString("Phone")).thenReturn("123456789"); // Sample data
        when(rs.getString("NgaySinh")).thenReturn("1990-01-01"); // Sample data
        when(pstm.executeQuery()).thenReturn(rs);
        when(DBConnect.getConnection()).thenReturn(cn);
        LoginService yourTestClass = new LoginService();
        List<NguoiDung> result = yourTestClass.getDataLogin();
        verify(cn).prepareStatement(anyString());
        verify(pstm).executeQuery();
        assertEquals(1, result.size());
        NguoiDung nd = result.get(0);
        assertEquals("1", nd.getIdNguoiDung());
        assertEquals("John Doe", nd.getHoten());
        assertEquals("password", nd.getMatkhau());
        assertEquals("Admin", nd.getRole());
        assertEquals(true, nd.isGioiTinh());
        assertEquals("123 Main St", nd.getDiachi());
        assertEquals("john.doe@example.com", nd.getEmail());
        assertEquals("123456789", nd.getPhone());
        assertEquals("1990-01-01", nd.getNgaysinh());
    }

    @Test
    public void testAddDataLogin() throws Exception {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        when(DBConnect.getConnection()).thenReturn(cn);
        when(cn.prepareStatement(anyString())).thenReturn(pstm);
        when(pstm.executeUpdate()).thenReturn(1); // Simulate successful insertion
        LoginService yourTestClass = new LoginService();
        NguoiDung nd = new NguoiDung();
        nd.setIdNguoiDung("1");
        nd.setHoten("John Doe");
        nd.setNgaysinh("1990-01-01");
        nd.setMatkhau("password");
        nd.setPhone("123456789");
        nd.setGioiTinh(true);
        nd.setDiachi("123 Main St");
        nd.setEmail("john.doe@example.com");
        boolean result = yourTestClass.addDataLogin(nd);
        verify(cn).prepareStatement(anyString());
        verify(pstm).setObject(anyInt(), any());
        verify(pstm).executeUpdate();
        assertTrue(result); // Expecting true as insertion is successful
    }

    @Test
    public void testUpdateDataLogin() throws Exception {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        when(DBConnect.getConnection()).thenReturn(cn);
        when(cn.prepareStatement(anyString())).thenReturn(pstm);
        when(pstm.executeUpdate()).thenReturn(1); // Simulate successful update
        LoginService yourTestClass = new LoginService();
        NguoiDung nd = new NguoiDung();
        boolean result = yourTestClass.updateDataLogin(nd);
        verify(cn).prepareStatement(anyString());
        verify(pstm).setObject(anyInt(), any());
        verify(pstm).executeUpdate();
        assertTrue(result);
    }

    @Test
    public void testUpdateQuyenHan() throws Exception {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        when(DBConnect.getConnection()).thenReturn(cn);
        when(cn.prepareStatement(anyString())).thenReturn(pstm);
        when(pstm.executeUpdate()).thenReturn(1); // Simulate successful update
        LoginService yourTestClass = new LoginService();
        boolean result = yourTestClass.updateQuyenHan("ndid", "tenq");
        verify(cn).prepareStatement(anyString());
        verify(pstm).setObject(1, "tenq");
        verify(pstm).setObject(2, "ndid");
        verify(pstm).executeUpdate();
        assertTrue(result); // Expecting true as update is successful
    }

    @Test
    public void testGetDataLoginFollowNameOrId() throws SQLException {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);
        when(DBConnect.getConnection()).thenReturn(cn);
        when(cn.prepareStatement(anyString())).thenReturn(pstm);
        when(pstm.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true).thenReturn(false); // Simulate one record
        when(rs.getString("NguoiDungId")).thenReturn("1"); // Sample data
        when(rs.getString("HoTen")).thenReturn("John Doe"); // Sample data
        when(rs.getString("MatKhau")).thenReturn("password"); // Sample data
        when(rs.getString("TenQuyen")).thenReturn("Admin"); // Sample data
        when(rs.getBoolean("GioiTinh")).thenReturn(true); // Sample data
        when(rs.getString("DiaChi")).thenReturn("123 Main St"); // Sample data
        when(rs.getString("Email")).thenReturn("john.doe@example.com"); // Sample data
        when(rs.getString("Phone")).thenReturn("123456789"); // Sample data
        when(rs.getString("NgaySinh")).thenReturn("1990-01-01"); // Sample data
        LoginService yourTestClass = new LoginService();
        List<NguoiDung> result = yourTestClass.getDataLoginFollowNameOrId("John");
        verify(cn).prepareStatement(anyString());
        verify(pstm).setObject(1, "John");
        verify(pstm).setObject(2, "%John%");
        verify(pstm).executeQuery();
        assertEquals(1, result.size()); // Expecting one record in the result list
        NguoiDung nd = result.get(0);
        assertEquals("1", nd.getIdNguoiDung());
        assertEquals("John Doe", nd.getHoten());
        assertEquals("password", nd.getMatkhau());
        assertEquals("Admin", nd.getRole());
        assertEquals(true, nd.isGioiTinh());
        assertEquals("123 Main St", nd.getDiachi());
        assertEquals("john.doe@example.com", nd.getEmail());
        assertEquals("123456789", nd.getPhone());
        assertEquals("1990-01-01", nd.getNgaysinh());
    }

    @Test
    public void testFindDataNguoiDungId() throws SQLException {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);
        when(DBConnect.getConnection()).thenReturn(cn);
        when(cn.prepareStatement(anyString())).thenReturn(pstm);
        when(pstm.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true); // Simulate one record
        when(rs.getString("NguoiDungId")).thenReturn("1"); // Sample data
        when(rs.getString("HoTen")).thenReturn("John Doe"); // Sample data
        when(rs.getString("MatKhau")).thenReturn("password"); // Sample data
        when(rs.getString("TenQuyen")).thenReturn("Admin"); // Sample data
        when(rs.getBoolean("GioiTinh")).thenReturn(true); // Sample data
        when(rs.getString("DiaChi")).thenReturn("123 Main St"); // Sample data
        when(rs.getString("Email")).thenReturn("john.doe@example.com"); // Sample data
        when(rs.getString("Phone")).thenReturn("123456789"); // Sample data
        when(rs.getString("NgaySinh")).thenReturn("1990-01-01"); // Sample data
        LoginService yourTestClass = new LoginService();
        NguoiDung result = yourTestClass.findDataNguoiDungId("1");
        verify(cn).prepareStatement(anyString());
        verify(pstm).setObject(1, "1");
        verify(pstm).executeQuery();
        assertNotNull(result); // Expecting a non-null result
        assertEquals("1", result.getIdNguoiDung());
        assertEquals("John Doe", result.getHoten());
        assertEquals("password", result.getMatkhau());
        assertEquals("Admin", result.getRole());
        assertEquals(true, result.isGioiTinh());
        assertEquals("123 Main St", result.getDiachi());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals("123456789", result.getPhone());
        assertEquals("1990-01-01", result.getNgaysinh());
    }

    @Test
    public void testGetDataLoginFollowGioiTinh() throws SQLException {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);
        when(DBConnect.getConnection()).thenReturn(cn);
        when(cn.prepareStatement(anyString())).thenReturn(pstm);
        when(pstm.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true).thenReturn(false); // Simulate one record
        when(rs.getString("NguoiDungId")).thenReturn("1"); // Sample data
        when(rs.getString("HoTen")).thenReturn("John Doe"); // Sample data
        when(rs.getString("MatKhau")).thenReturn("password"); // Sample data
        when(rs.getString("TenQuyen")).thenReturn("Admin"); // Sample data
        when(rs.getBoolean("GioiTinh")).thenReturn(true); // Sample data
        when(rs.getString("DiaChi")).thenReturn("123 Main St"); // Sample data
        when(rs.getString("Email")).thenReturn("john.doe@example.com"); // Sample data
        when(rs.getString("Phone")).thenReturn("123456789"); // Sample data
        when(rs.getString("NgaySinh")).thenReturn("1990-01-01"); // Sample data
        LoginService yourTestClass = new LoginService();
        List<NguoiDung> result = yourTestClass.getDataLoginFollowGioiTinh(true);
        verify(cn).prepareStatement(anyString());
        verify(pstm).setObject(1, true);
        verify(pstm).executeQuery();
        assertEquals(1, result.size()); // Expecting one record in the result list
        NguoiDung nd = result.get(0);
        assertEquals("1", nd.getIdNguoiDung());
        assertEquals("John Doe", nd.getHoten());
        assertEquals("password", nd.getMatkhau());
        assertEquals("Admin", nd.getRole());
        assertEquals(true, nd.isGioiTinh());
        assertEquals("123 Main St", nd.getDiachi());
        assertEquals("john.doe@example.com", nd.getEmail());
        assertEquals("123456789", nd.getPhone());
        assertEquals("1990-01-01", nd.getNgaysinh());
    }

    @Test
    public void testGetDataLoginFollowQuyenHan() throws SQLException {
        Connection cn = mock(Connection.class);
        PreparedStatement pstm = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);
        when(DBConnect.getConnection()).thenReturn(cn);
        when(cn.prepareStatement(anyString())).thenReturn(pstm);
        when(pstm.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true).thenReturn(false); // Simulate one record
        when(rs.getString("NguoiDungId")).thenReturn("1"); // Sample data
        when(rs.getString("HoTen")).thenReturn("John Doe"); // Sample data
        when(rs.getString("MatKhau")).thenReturn("password"); // Sample data
        when(rs.getString("TenQuyen")).thenReturn("Admin"); // Sample data
        when(rs.getBoolean("GioiTinh")).thenReturn(true); // Sample data
        when(rs.getString("DiaChi")).thenReturn("123 Main St"); // Sample data
        when(rs.getString("Email")).thenReturn("john.doe@example.com"); // Sample data
        when(rs.getString("Phone")).thenReturn("123456789"); // Sample data
        when(rs.getString("NgaySinh")).thenReturn("1990-01-01"); // Sample data
        LoginService yourTestClass = new LoginService();
        List<NguoiDung> result = yourTestClass.getDataLoginFollowQuyenHan("Admin");
        verify(cn).prepareStatement(anyString());
        verify(pstm).setObject(1, "Admin");
        verify(pstm).executeQuery();
        assertEquals(1, result.size()); // Expecting one record in the result list
        NguoiDung nd = result.get(0);
        assertEquals("1", nd.getIdNguoiDung());
        assertEquals("John Doe", nd.getHoten());
        assertEquals("password", nd.getMatkhau());
        assertEquals("Admin", nd.getRole());
        assertEquals(true, nd.isGioiTinh());
        assertEquals("123 Main St", nd.getDiachi());
        assertEquals("john.doe@example.com", nd.getEmail());
        assertEquals("123456789", nd.getPhone());
        assertEquals("1990-01-01", nd.getNgaysinh());
    }
}
