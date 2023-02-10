package com.example.Project.service;

import com.example.Project.Dao.LimitDao;
import com.example.Project.model.Client;
import com.example.Project.model.Limit;
import com.example.Project.model.TypeOfLimit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LimitServiceTest {
    @Mock
    private TypeService typeService;

    @Mock
    private ClientService clientService;

    @Mock
    private LimitDao limitDao;

    @InjectMocks
    private LimitService limitService;

    @Test
    public void testAddSuccess() {

        TypeOfLimit type = new TypeOfLimit();
        type.setId(1);
        Mockito.when(typeService.getById(1)).thenReturn(type);

        Client client = new Client();
        client.setId(1);
        Mockito.when(clientService.getById(1)).thenReturn(client);

        Limit limit = new Limit();
        limit.setTypeOfLimitID(1);
        limit.setClientID(1);
        limit.setTypeOfLimitID(1);

        Mockito.when(limitDao.add(limit)).thenReturn(limit);


        Limit result = limitService.add(limit);


        Assert.assertEquals(limit, result);
        Mockito.verify(typeService).getById(1);
        Mockito.verify(clientService).getById(1);
        Mockito.verify(limitDao).add(limit);
    }

    @Test
    public void testAddFailWhenTypeNotFound() {

        TypeOfLimit type = null;
        Mockito.when(typeService.getById(1)).thenReturn(type);

        Client client = new Client();
        client.setId(1);
//        Mockito.when(clientService.getById(1)).thenReturn(client);

        Limit limit = new Limit();
        limit.setTypeOfLimitID(1);
        limit.setClientID(1);
        limit.setTypeOfLimitID(1);

        Limit result = limitService.add(limit);


        Assert.assertNull(result);
        Mockito.verify(typeService).getById(1);
        Mockito.verify(clientService, Mockito.never()).getById(1);
        Mockito.verify(limitDao, Mockito.never()).add(limit);
    }
}
