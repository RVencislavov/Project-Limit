package com.example.Project.service;

import com.example.Project.Dao.LimitDao;
import com.example.Project.Dao.TypeDao;
import com.example.Project.model.TypeOfLimit;
import com.example.Project.service.TypeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TypeServiceTest {
    private static final int TEST_ID = 1;
    private static final String TEST_FULL_NAME = "Test Full Name";
    private static final String TEST_ABR = "TFN";

    @Mock
    private TypeDao typeDao;

    @Mock
    private LimitDao limitDao;

    @InjectMocks
    private TypeService typeService;

    private TypeOfLimit type;

    @Before
    public void setUp() {
        type = new TypeOfLimit();
        type.setId(TEST_ID);
        type.setFullNameOfTheLimit(TEST_FULL_NAME);
        type.setLimitTypeAbbreviation(TEST_ABR);
    }

    @Test
    public void getById_returnsType() {
        when(typeDao.getByTypeId(TEST_ID)).thenReturn(type);

        TypeOfLimit result = typeService.getById(TEST_ID);

        verify(typeDao, times(1)).getByTypeId(TEST_ID);
        assertEquals(type, result);
    }

    @Test
    public void addType_returnsType() {
        when(typeDao.addType(type)).thenReturn(type);

        TypeOfLimit result = typeService.addType(type);

        verify(typeDao, times(1)).addType(type);
        assertEquals(type, result);
    }

    @Test
    public void updateType_returnsUpdatedType() {
        when(typeDao.getByTypeId(TEST_ID)).thenReturn(type);
        when(typeDao.updateType(TEST_ID, type)).thenReturn(type);

        TypeOfLimit result = typeService.updateType(TEST_ID, type);

        verify(typeDao, times(1)).getByTypeId(TEST_ID);
        verify(typeDao, times(1)).updateType(TEST_ID, type);
        assertEquals(type, result);
    }

 //  @Test
 //  public void updateType_returnsNullForInvalidId() {
 //      when(typeDao.getByTypeId(TEST_ID)).thenReturn(null);

 //      TypeOfLimit result = typeService.updateType(TEST_ID, type);

 //      verify(typeDao, times(1)).getByTypeId();
 //  }

}