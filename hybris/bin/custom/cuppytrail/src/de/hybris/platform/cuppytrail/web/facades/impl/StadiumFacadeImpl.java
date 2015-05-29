package de.hybris.platform.cuppytrail.web.facades.impl;
 
import de.hybris.platform.cuppytrail.web.data.StadiumDataTO;
import de.hybris.platform.cuppytrail.web.facades.StadiumFacade;
import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.cuppytrail.services.StadiumService;

import java.util.ArrayList;
import java.util.List;
 
 
public class StadiumFacadeImpl implements StadiumFacade
{
	private StadiumService stadiumService;
 
    @Override
    public StadiumDataTO getStadiumDetails(final String name)
    {
   	 StadiumModel stadium = stadiumService.getStadiumDetails(name);
        return new StadiumDataTO(stadium.getCode(), stadium.getCapacity());
    }
 
    @Override
    public List<StadiumDataTO> getAllStadium()
    {
        final List<StadiumDataTO> dataTOs = new ArrayList<StadiumDataTO>();
        List<StadiumModel> myList = stadiumService.getAllStadium();
        for (StadiumModel stadium : myList)
        {
      	  dataTOs.add(new StadiumDataTO(stadium.getCode(),stadium.getCapacity()));
        }
        
        return dataTOs;
    }
    
    @Override
    public void setStadiumService(final StadiumService stadiumService)
    {
        this.stadiumService = stadiumService;
    }
     
    @Override
    public StadiumService getStadiumService()
    {
        return stadiumService;
    }
 
}
