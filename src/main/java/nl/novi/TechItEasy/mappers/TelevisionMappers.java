package nl.novi.TechItEasy.mappers;

import nl.novi.TechItEasy.dtos.TelevisionDto;
import nl.novi.TechItEasy.dtos.TelevisionInputDto;
import nl.novi.TechItEasy.dtos.TelevisionSalesDto;
import nl.novi.TechItEasy.models.Television;
import org.springframework.stereotype.Component;

@Component
public class TelevisionMappers {
    public static TelevisionDto toTelevisionDto(Television t) {
        var dto = new TelevisionDto();
        dto.id = t.getId();
        dto.type = t.getType();
        dto.brand = t.getBrand();
        dto.name = t.getName();
        dto.price = t.getPrice();
        dto.availableSize = t.getAvailableSize();
        dto.refreshRate = t.getRefreshRate();
        dto.screenType = t.getScreenType();
        dto.screenQuality = t.getScreenQuality();
        dto.smartTv = t.isSmartTv();
        dto.wifi = t.isWifi();
        dto.voiceControl = t.isVoiceControl();
        dto.hdr = t.isHdr();
        dto.bluetooth = t.isBluetooth();
        dto.ambiLight = t.isAmbiLight();
        dto.originalStock = t.getOriginalStock();
        dto.sold = t.getSold();

        return dto;
    }

    public static Television toTelevision(TelevisionInputDto tdto) {
        var television = new Television();
        television.setId(tdto.id);
        television.setType(tdto.type);
        television.setBrand(tdto.brand);
        television.setName(tdto.name);
        television.setPrice(tdto.price);
        television.setAvailableSize(tdto.availableSize);
        television.setRefreshRate(tdto.refreshRate);
        television.setScreenType(tdto.screenType);
        television.setScreenQuality(tdto.screenQuality);
        television.setSmartTv(tdto.smartTv);
        television.setWifi(tdto.wifi);
        television.setVoiceControl(tdto.voiceControl);
        television.setHdr(tdto.hdr);
        television.setBluetooth(tdto.bluetooth);
        television.setAmbiLight(tdto.ambiLight);
        television.setOriginalStock(tdto.originalStock);
        television.setSold(tdto.sold);

        return television;
    }

    public static TelevisionSalesDto toTelevisionSalesDto(Television t) {
        var televisionSalesDto = new TelevisionSalesDto();
        televisionSalesDto.id = t.getId();
        televisionSalesDto.price = t.getPrice();
        televisionSalesDto.originalStock = t.getOriginalStock();
        televisionSalesDto.sold = t.getSold();

        return televisionSalesDto;
    }
}
