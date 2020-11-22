package cpm.atguigu.springcloud.service.serviceIml;

import cpm.atguigu.springcloud.dao.OrderDao;
import cpm.atguigu.springcloud.domain.Order;
import cpm.atguigu.springcloud.service.AccountService;
import cpm.atguigu.springcloud.service.OrderService;
import cpm.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceIml implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
    @GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        System.out.println("--------->开始创建订单");
        orderDao.createOrder(order);
        System.out.println("---------减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        System.out.println("---------扣钱开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        System.out.println("---------修改订单信息");
        orderDao.update(order.getUserId(),0);
    }

    @Override
    public void update(Long userId, Integer status) {
        orderDao.update(userId,status);
    }

    @Override
    public Order get() {

        return orderDao.get();
    }
}
