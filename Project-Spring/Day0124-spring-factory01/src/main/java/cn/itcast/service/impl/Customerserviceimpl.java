package cn.itcast.service.impl;

import cn.itcast.dao.Costomerdao;
import cn.itcast.dao.impl.Costomerdaoimpl;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.Customerservice;

public class Customerserviceimpl implements Customerservice{

 // private Costomerdaoimpl costomerdao=new Costomerdaoimpl();

//   private  Costomerdao costomerdao=BeanFactory.getbeanFactory().getcostomerdao();

 private  Costomerdao costomerdao= (Costomerdao) BeanFactory.getbeanFactory().getbean("Costomerdao");



        @Override
    public void costomerservic() {
        costomerdao.costomerdao();
    }
}
