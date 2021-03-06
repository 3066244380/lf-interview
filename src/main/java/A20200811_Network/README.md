# https://github.com/a982338665/lf-mkd-java-win-sock-demo.git
# https://blog.csdn.net/wx_962464/article/details/51043069 https
## keepalive

## telnet

## 1.一个电脑有几个网卡？网卡mac地址，m地址修改有什么意义？

    1.笔记本电脑一般有两块网卡，一个PCI网卡，一个WireLess无线网卡。
    2.当我们安装虚拟机后，会有虚拟网卡，比如安装vmware，自动增加两个虚拟网卡：
        VMnet1和VMnet8，VMnet1是虚拟机主机模式的网卡，VMnet8是虚拟机的NAT模式网卡。
    3.每个网卡上都有单独的硬件地址，mac地址，全球唯一
        mac地址：全称Media Access Control Address
        介质访问地址，又名硬件地址
        每个网卡都有全球唯一的mac地址，跟mac电脑不是一个意思
    4.windows查看mac：
        ipconfig /all
        其中，物理地址为本机的MAC地址。
    5.linux查看mac：
        1.linux：
            ifconfig
            其中，HWaddr字段就是mac地址。
        2.centos：
            cat etc/sysconfig/network-scripts/ifcfg-eth0
            cat /sys/class/net/eth0/address
            demsg | grep eth
            ifconfig eth0 | grep HWaddr
    6.注意：网卡mac是可以修改的，
    7.修改mac的用途：
        一些公司,学校等都会对网络进行统一管理,其中一个很重要的统一管理是就是根据网卡的物理地址绑定IP地址。如果你在公司上网，进行BT下载，QQ上网等违反了规定的，
        网管就可以根据你所登记的网卡地址封了你的IP地址。
        要解决IP被封的问题根本就是要修改网卡地址，修改网卡MAC地址有多种方法：
        一、直接修改
            打开网络连接，在“本地连接”的小电脑图标，右键打开“属性”。
            点击上图的配置，在下图选择“Network Address”，然后在右侧的“值”中输入12个十六进制的数字（注意，mac地址每一位从0－F都是合法的，如00-50-8D-11-2F-9B，前3个字节表示制造商，
            后三个字节表示编号），单击“确定”保存设置，之后停用网络，在启用网络便可（或者重启电脑）

## 2.IP地址？

    1.ip地址：门牌号的作用，每个网卡、机器都有一个或多个ip地址
        ·IPv4：采用32位地址长度，只有大约43亿个地址
        ·IPv6：采用128位地址长度，几乎可以不受限制地提供地址
            ·解决地址短缺问题
            ·端到端IP连接
            ·服务质量（QoS）
            ·安全性
            ·多播
            ·移动性
            ·即插即用等
        -IPV4：192.168.0.100 每段0-255
        -IPV6:128bit长，分成8段，每段4个16进制数
    2.ip协议：也叫因特网协议，是所有计算机能在因特网上实现互通的原因，即各种设备基本单元的格式不同，需要转换为统一格式（IP数据报），来实现互通
    3.类型：
        ·公有地址：
            由Inter NIC（Internet Network Information Center因特网信息中心）负责。这些IP地址分配给注册并向Inter NIC提出申请的组织机构。通过它直接访问因特网。
        ·私有地址：
            私有地址（Private address）属于非注册地址，专门为组织机构内部使用。
            A类 10.0.0.0--10.255.255.255
            B类 172.16.0.0--172.31.255.255
            C类 192.168.0.0--192.168.255.255
    4.ip分配：
        TCP/IP协议需要针对不同的网络进行不同的设置，且每个节点一般需要一个“IP地址”、一个“子网掩码”、一个“默认网关”。不过，可以通过动态主机配置协议（DHCP），
        给客户端自动分配一个IP地址，避免了出错，也简化了TCP/IP协议的设置。
        IP地址现由因特网名字与号码指派公司ICANN（Internet Corporation for Assigned Names and Numbers）分配。
        InterNIC：负责美国及其他地区；
        ENIC：负责欧洲地区；
        APNIC（Asia Pacific Network Information Center）：　我国用户可向APNIC申请（要缴费）
        PS：1998年，APNIC的总部从东京搬迁到澳大利亚布里斯班。
        负责A类IP地址分配的机构是ENIC
        负责北美B类IP地址分配的机构是InterNIC
        负责亚太B类IP地址分配的机构是APNIC    

## 3.端口？
    
    1.分类：
        物理端口：又称接口
            ·计算机背板的RJ45网口，
            ·交换机路由器集线器等RJ45端
            ·电话使用RJ11插口也属于物理端口的范畴
        虚拟端口：
            ·80端口等
    2.分类2：
        硬件端口
        网络端口
        软件端口
    3.协议端口：
        1.如果把IP地址比作一间房子 ，端口就是出入这间房子的门。真正的房子只有几个门，但是一个IP地址的端口可以有65536（即：2^16）个之多！端口是通过端口号来标记的，
            端口号只有整数，范围是从0 到65535（2^16-1）。
        2.详情：
            ·范围：0-65535
            ·0-1023：一般被用作知名服务器的端口，被预定，如FTP、HTTP、SMTP等
        3.端口其实就是队，操作系统为各个进程分配了不同的队，数据包按照目的端口被推入相应的队中，等待被进程取用，在极特殊的情况下，这个队也是有可能溢出的，
            不过操作系统允许各进程指定和调整自己的队的大小。
            不光接受数据包的进程需要开启它自己的端口，发送数据包的进程也需要开启端口，这样，数据包中将会标识有源端口，以便接受方能顺利地回传数据包到这个端
    4.端口类型：
        1.周知端口：
            众所周知的端口，0-1023
            其中，服务于软件的可以更改
            其中，服务于系统协议使用固定的端口号，不能被改变，例如：139 端口专门用于NetBIOS与TCP/IP之间的通信
        2.动态端口
            动态端口的范围是从49152到65535。之所以称为动态端口，是因为它 一般不固定分配某种服务，而是动态分配。
        3.注册端口
            端口1024到49151，分配给用户进程或应用程序
    5.端口作用：
        1.入侵中的作用：
            入侵者通常会用扫描器对目标主机的端口进行扫描，以确定哪些端口是开放的，从开放的端口，入侵者可以知道目标主机大致提供了哪些服务，进而猜测可能存在的漏洞，
            因此对端口的扫描可以帮助我们更好的了解目标主机，而对于管理员，扫描本机的开放端口也是做好安全防范的第一步。
        2.分类：
            面向连接服务 - 电话
                建立连接--拨号
                等待应答后--相互传递信息
                最后还要释放连接--挂电话
            无连接服务   - 写信
                地址姓名填好以后直接往邮筒一扔
        3.TCP/IP协议在网络层是无连接的（数据包只管往网上发，如何传输和到达以及是否到达由网络设备来管理）。而"端口"，是传输层的内容，是面向连接的。
            协议里面低于1024的端口都有确切的定义，它们对应着因特网上常见的一些服务。

## 4.TCP/IP协议？Transmission Control Protocol/Internet Protocol，传输控制协议/网际协议 也称网络通讯协议
    
    1.定义：是指能够在多个不同网络间实现信息传输的协议簇。它并不是仅代表TCP协议和IP协议，而是指一个由FTP、SMTP、TCP、UDP、IP等协议构成的协议簇， 
        只是因为在TCP/IP协议中TCP协议和IP协议最具代表性，所以被称为TCP/IP协议
    2.简介：
        1.网络使用中最基本的通信协议
        2.规定了互联网通信标准和方法
        3.保证网络数据信息及时，完整的两个重要协议
        4.四层协议：
            应用层：
                主要协议：有Telnet、FTP、SMTP等
                接收：接收来自传输层的数据
                发送：按不同应用要求与方式将数据传输至传输层
            传输层:
                主要协议：有UDP、TCP
                是使用者使用平台和计算机信息网内部数据结合的通道，可以实现数据传输与数据共享
            网络层：
                主要协议：有ICMP、IP、IGMP
                主要负责网络中数据包的传送等
            数据链路层-网络访问层，也称网路接口层：
                主要协议：有ARP、RARP，
                主要功能：是提供链路管理错误检测、对不同通信媒介有关信息细节问题进行有效处理等
        5.TCP/IP协议组成:
            1.在一定程度上参考了OSI的体系结构，OSI七层模型，从上到下依次为：
                物理层、数据链路层、网络层、运输层、会话层、表示层和应用层,
            2.TCP/IP协议中合并为4层：
                应用层、表示层、会话层三个层次提供的服务相差不是很大，所以合为【应用层】
                数据链路层和物理层的内容相差不多，所以在TCP/IP协议中它们被归并在【网络接口层】一个层次里。
                由于【传输层】和【网络层】在网络协议中的地位十分重要，所以在TCP/IP协议中它们被作为独立的两个层次

## 5.三次握手四次挥手相关面试题？？
    
    1.请画出三次握手和四次挥手的示意图
    2.为什么连接的时候是三次握手？
    3.什么是半连接队列？
    4.ISN(Initial Sequence Number)是固定的吗？
    5.三次握手过程中可以携带数据吗？
    6.如果第三次握手丢失了，客户端服务端会如何处理？
    7.SYN攻击是什么？
    8.挥手为什么需要四次？
    9.四次挥手释放连接时，等待2MSL的意义?

    1.三次握手：
        1.本质：指建立一个TCP连接时，需要客户端和服务器总共发送3个包
        2.作用：确认双方的接收能力和发送能力是否正常、指定自己的初始化序列号为后面的可靠性传送做准备
        3.实质：连接服务器指定端口，建立TCP连接，并同步连接双方的序列号和确认号，交换TCP窗口大小信息
        4.过程：客户端处于 Closed 的状态，服务端处于 Listen 状态。
            第一次握手：客户端给服务端发一个 SYN 报文，并指明客户端的初始化序列号 ISN©。此时客户端处于 SYN_SEND 状态。
                        首部的同步位SYN=1，初始序号seq=x，SYN=1的报文段不能携带数据，但要消耗掉一个序号。
            第二次握手：服务器收到客户端的 SYN 报文之后，会以自己的 SYN 报文作为应答，并且也是指定了自己的初始化序列号 ISN(s)。同时会把客户端的 ISN + 1 作为ACK 的值，
                        表示自己已经收到了客户端的 SYN，此时服务器处于 SYN_REVD 的状态。
                        在确认报文段中SYN=1，ACK=1，确认号ack=x+1，初始序号seq=y。
            第三次握手：客户端收到 SYN 报文之后，会发送一个 ACK 报文，当然，也是一样把服务器的 ISN + 1 作为 ACK 的值，表示已经收到了服务端的 SYN 报文，
                        此时客户端处于 ESTABLISHED 状态。服务器收到 ACK 报文之后，也处于 ESTABLISHED 状态，此时，双方已建立起了连接
                        确认报文段ACK=1，确认号ack=y+1，序号seq=x+1（初始为seq=x，第二个报文段所以要+1），ACK报文段可以携带数据，不携带数据则不消耗序号。
            在socket编程中，客户端执行connect()时，将触发三次握手。
    2.为什么需要三次握手，两次，或者4次不行吗？
        结论：两次不够，4次多余
        握手目的：确认服务端，客户端收发能力正常
        第一次握手：客户端发送网络包，服务端收到了。
            这样服务端就能得出结论：客户端的发送能力、服务端的接收能力是正常的。
        第二次握手：服务端发包，客户端收到了。
            这样客户端就能得出结论：服务端的接收、发送能力，客户端的接收、发送能力是正常的。不过此时服务器并不能确认客户端的接收能力是否正常。
        第三次握手：客户端发包，服务端收到了。
            这样服务端就能得出结论：客户端的接收、发送能力正常，服务器自己的发送、接收能力也正常。
            因此，需要三次握手才能确认双方的接收与发送能力是否正常。
        两次握手的问题：
            客户端发出第一次连接请求：报文由于网络延缓或者丢失，服务端未确认，客户端进行重传
            客户端发出第二次连接请求：正常数据传输
            此时，第一次延缓的连接请求到达服务器，此时的服务端会认为这是一个新的请求，于是向客户端发送同意确认连接，
            若不是采用三次握手，此时就意味着连接已建立，但此时的客户端显然会忽略服务端发来的确认连接的消息，也不发送数据，
            所以服务端会处于等待状态，等待客户端发来数据，浪费资源
    3.什么是半连接队列，全连接队列？
        半连接队列：服务器第一次收到客户端的SYN之后就会处于 SYN_RCVD状态，此时还未完全建立连接，服务器会把此种状态放在一个队列中，这种队列就称为半连接队列。
        全连接队列：完成三次握手，建立了连接就会放在全连接队列中
        服务器SYNC-ACK重传次数问题：
            服务器发送完SYNC-ACK包：
                未收到客户确认包，服务器进行首次重传
                等待一段时间仍未收到客户确认包，进行第二次重传
                如果重传次数超过系统规定的最大重传次数，系统将该连接信息从半连接队列中删除。
            注意：每次重传等待的时间不一定相同，一般会是指数增长，例如间隔时间为 1s，2s，4s，8s…
    4. ISN(Initial Sequence Number)是固定的吗？
        结论：不是
        解释：三次握手的其中一个重要功能是客户端和服务端交换 ISN(Initial Sequence Number)，以便让对方知道接下来接收数据的时候如何按序列号组装数据。
              如果 ISN 是固定的，攻击者很容易猜出后续的确认号，因此 ISN 是动态生成的
    5.三次握手过程中可以携带数据吗？
        结论：第一次不能，第三次能，第二次是服务端回信，不会带数据
        解释：
            若第一次能携带数据，那么服务器就更容易被攻击，因为攻击者就不会理会服务器的接收，发送能力，只需要疯狂发syn报文，让服务器话很多内存，时间来处理接收这些报文
            第三次：因为此时客户端已经处于ESTABLISHED 状态。对于客户端来说，他已经建立起连接了，并且也已经知道服务器的接收、发送能力是正常的了，所以能携带数据也没啥毛病。
    6.SYN攻击问题？
        服务器端的资源分配是在二次握手时分配的，而客户端的资源是在完成三次握手时分配的，所以服务器容易受到SYN洪泛攻击。
        SYN攻击就是Client在短时间内伪造大量不存在的IP地址，并向Server不断地发送SYN包，Server则回复确认包，并等待Client确认，由于源地址不存在，因此Server需要不断重发直至超时，
        这些伪造的SYN包将长时间占用未连接队列，导致正常的SYN请求因为队列满而被丢弃，从而引起网络拥塞甚至系统瘫痪。SYN 攻击是一种典型的 DoS/DDoS 攻击。
        检测 SYN 攻击非常的方便，当你在服务器上看到大量的半连接状态时，特别是源IP地址是随机的，基本上可以断定这是一次SYN攻击。在 Linux/Unix 上可以使用系统自带的 netstats 命令来检测 SYN 攻击。
        netstat -n -p TCP | grep SYN_RECV
        常见的防御 SYN 攻击的方法有如下几种：
            缩短超时（SYN Timeout）时间
            增加最大半连接数
            过滤网关防护
            SYN cookies技术
    7.四次挥手？
        原因：由TCP的半关闭（half-close）造成的。所谓的半关闭，其实就是TCP提供了连接的一端在结束它的发送后还能接收来自另一端数据的能力
        目的：TCP 的连接的拆除需要发送四个包，因此称为四次挥手(Four-way handshake)，客户端或服务器均可主动发起挥手动作
        过程：刚开始双方都处于 ESTABLISHED 状态
            客户端先发起关闭请求：
                1.第一次挥手：客户端发送一个 FIN 报文，报文中会指定一个序列号。此时客户端处于 FIN_WAIT1 状态。
                  即发出连接释放报文段（FIN=1，序号seq=u），并停止再发送数据，主动关闭TCP连接，进入FIN_WAIT1（终止等待1）状态，等待服务端的确认。
                2.第二次挥手：服务端收到 FIN 之后，会发送 ACK 报文，且把客户端的序列号值 +1 作为 ACK 报文的序列号值，表明已经收到客户端的报文了，此时服务端处于 CLOSE_WAIT 状态。
                  即服务端收到连接释放报文段后即发出确认报文段（ACK=1，确认号ack=u+1，序号seq=v），服务端进入CLOSE_WAIT（关闭等待）状态，此时的TCP处于半关闭状态，客户端到服务端的连接释放。
                  客户端收到服务端的确认后，进入FIN_WAIT2（终止等待2）状态，等待服务端发出的连接释放报文段。
                3.第三次挥手：如果服务端也想断开连接了，和客户端的第一次挥手一样，发给 FIN 报文，且指定一个序列号。此时服务端处于 LAST_ACK 的状态。
                  即服务端没有要向客户端发出的数据，服务端发出连接释放报文段（FIN=1，ACK=1，序号seq=w，确认号ack=u+1），服务端进入LAST_ACK（最后确认）状态，等待客户端的确认
                4.第四次挥手：客户端收到 FIN 之后，一样发送一个 ACK 报文作为应答，且把服务端的序列号值 +1 作为自己 ACK 报文的序列号值，此时客户端处于 TIME_WAIT 状态。
                  需要过一阵子以确保服务端收到自己的 ACK 报文之后才会进入 CLOSED 状态，服务端收到 ACK 报文之后，就处于关闭连接了，处于 CLOSED 状态。
                  即客户端收到服务端的连接释放报文段后，对此发出确认报文段（ACK=1，seq=u+1，ack=w+1），客户端进入TIME_WAIT（时间等待）状态。
                  此时TCP未释放掉，需要经过时间等待计时器设置的时间2MSL后，客户端才进入CLOSED状态。
            收到一个FIN只意味着在这一方向上没有数据流动。客户端执行主动关闭并进入TIME_WAIT是正常的，服务端通常执行被动关闭，不会进入TIME_WAIT状态。
            在socket编程中，任何一方执行close()操作即可产生挥手操作。
    8.挥手为什么需要四次？
        因为当服务端收到客户端的SYN连接请求报文后，可以直接发送SYN+ACK报文。其中ACK报文是用来应答的，SYN报文是用来同步的。但是关闭连接时，当服务端收到FIN报文时，很可能并不会立即关闭SOCKET，
        所以只能先回复一个ACK报文，告诉客户端，“你发的FIN报文我收到了”。只有等到我服务端所有的报文都发送完了，我才能发送FIN报文，因此不能一起发送。故需要四次挥手。
    9.2MSL等待状态
        TIME_WAIT状态也成为2MSL等待状态。每个具体TCP实现必须选择一个报文段最大生存时间MSL（Maximum Segment Lifetime），它是任何报文段被丢弃前在网络内的最长时间。
        这个时间是有限的，因为TCP报文段以IP数据报在网络内传输，而IP数据报则有限制其生存时间的TTL字段。
        对一个具体实现所给定的MSL值，处理的原则是：当TCP执行一个主动关闭，并发回最后一个ACK，该连接必须在TIME_WAIT状态停留的时间为2倍的MSL。
        这样可让TCP再次发送最后的ACK以防这个ACK丢失（另一端超时并重发最后的FIN）。
        这种2MSL等待的另一个结果是这个TCP连接在2MSL等待期间，定义这个连接的插口（客户的IP地址和端口号，服务器的IP地址和端口号）不能再被使用。这个连接只能在2MSL结束后才能再被使用。
    10.四次挥手释放连接时，等待2MSL的意义?
        MSL是Maximum Segment Lifetime的英文缩写，可译为“最长报文段寿命”，它是任何报文在网络上存在的最长时间，超过这个时间报文将被丢弃。
        为了保证客户端发送的最后一个ACK报文段能够到达服务器。因为这个ACK有可能丢失，从而导致处在LAST-ACK状态的服务器收不到对FIN-ACK的确认报文。服务器会超时重传这个FIN-ACK，
        接着客户端再重传一次确认，重新启动时间等待计时器。最后客户端和服务器都能正常的关闭。假设客户端不等待2MSL，而是在发送完ACK之后直接释放关闭，一但这个ACK丢失的话，服务器就无法正常的进入关闭连接状态。
        两个理由：
            1.保证客户端发送的最后一个ACK报文段能够到达服务端。
                这个ACK报文段有可能丢失，使得处于LAST-ACK状态的B收不到对已发送的FIN+ACK报文段的确认，服务端超时重传FIN+ACK报文段，而客户端能在2MSL时间内收到这个重传的FIN+ACK报文段，接着客户端重传一次确认，重新启动2MSL计时器，最后客户端和服务端都进入到CLOSED状态，若客户端在TIME-WAIT状态不等待一段时间，而是发送完ACK报文段后立即释放连接，则无法收到服务端重传的FIN+ACK报文段，所以不会再发送一次确认报文段，则服务端无法正常进入到CLOSED状态。
            2.防止“已失效的连接请求报文段”出现在本连接中。
                客户端在发送完最后一个ACK报文段后，再经过2MSL，就可以使本连接持续的时间内所产生的所有报文段都从网络中消失，使下一个新的连接中不会出现这种旧的连接请求报文段
    11.为什么TIME_WAIT状态需要经过2MSL才能返回到CLOSE状态？
       理论上，四个报文都发送完毕，就可以直接进入CLOSE状态了，但是可能网络是不可靠的，有可能最后一个ACK丢失。所以TIME_WAIT状态就是用来重发可能丢失的ACK报文。
    
## 6.http请求与RPC调用问题？

    0.结论：根据不同业务场景灵活站位    
    1.http请求：Restful大有超过RPC的趋势
        优点：
            ·可读性好
            ·可得到防火墙支持，跨语言支持
        缺点：
            ·有用信息占比少：毕竟HTTP工作在第七层，包含了大量的HTTP头等信息
            ·效率低，还是因为第七层的缘故
            ·可读性似乎没有必要，因为我们可以引入网关增加可读性
            ·HTTP协议调用远程方法比较复杂，要封装各种参数名和参数值
    2.rpc请求精简
        支持长连接，减少了网络开销
        拥有注册中心，鼓舞治理更方便
        有监控，容易定位问题
        对调用方来说，无感知，统一化
    3.异同点：
        ·传输协议：
            RPC：可以基于TCP，也可以基于HTTP协议
            HTTP：基于http协议
        ·传输效率：
            RCP：使用自定义tcp协议，使请求报文体积更小
                或者使用HTTP2协议，减少报文体积，提高传输效率
            HTTP：
                基于http1.1,请求中会包含很多无用内容
                基于http2，简单封装可作为rpc使用
        ·性能比较：
            RPC：基于thrift实现高效的二进制传输
            http：大部分通过json实现，字节大小和序列化耗时比thrift更消耗性能
        ·负载均衡：
            RPC:自带负载均衡策略
            http：需要配置nginx
        ·服务治理：
            RPC：能自动通知，不影响上游
            http：需事先通知，更改nginx配置
        ·总结：
            RPC：主要用于公司内部服务调用，性能消耗低，传输效率高，服务治理方便
            http：主要用于对外的异构环境，浏览器调用，接口调用，第三方调用

## 7 https怎么保证安全性？https://blog.csdn.net/wx_962464/article/details/51043069

    1.结论：
        https实际就是在TCP层与http层之间加入了SSL/TLS来为上层的安全保驾护航，主要用到对称加密、非对称加密、证书，等技术进行客户端与服务器的数据加密传输，最终达到保证整个通信的安全性
    2.介绍：
        https-以安全为目标的http通道，http下加入SSL层
    3.https作用：
        ·内容加密：建立信息安全通道，保证数据传输安全
        ·身份认证：确认网站真实性
        ·数据完整性：防止内容被第三方冒充或者篡改
    4.https劣势：
        ·对数据加解密决定了他比http慢，需要进行非对称的加解密，首次连接较慢，当然现在也有很多优化
        ·出于安全考虑，浏览器不会在本地保存HTTPS缓存。实际上，只要在HTTP头中使用特定命令，HTTPS是可以缓存的。Firefox默认只在内存中缓存HTTPS。但是，只要头命令中有Cache-Control: Public，
            缓存就会被写到硬盘上。 IE只要http头允许就可以缓存https内容，缓存策略与是否使用HTTPS协议无关。
    5.HTTPS和HTTP的区别
        https协议需要到CA申请证书，一般免费证书很少，需要交费。
        http是超文本传输协议，信息是明文传输；https 则是具有安全性的ssl加密传输协议。
        http和https使用的是完全不同的连接方式，用的端口也不一样，前者是80，后者是443。
        http的连接很简单，是无状态的；HTTPS协议是由SSL+HTTP协议构建的可进行加密传输、身份认证的网络协议，比http协议安全。
    6.对称加密
        对称加密(也叫私钥加密)指加密和解密使用相同密钥的加密算法。有时又叫传统密码算法，就是加密密钥能够从解密密钥中推算出来，同时解密密钥也可以从加密密钥中推算出来。
        而在大多数的对称算法中，加密密钥和解密密钥是相同的，所以也称这种加密算法为秘密密钥算法或单密钥算法。
        常见的对称加密有：DES（Data Encryption Standard）、AES（Advanced Encryption Standard）、RC4、IDEA
    7.非对称加密
        与对称加密算法不同，非对称加密算法需要两个密钥：公开密钥（publickey）和私有密钥（privatekey）；并且加密密钥和解密密钥是成对出现的。
        非对称加密算法在加密和解密过程使用了不同的密钥，非对称加密也称为公钥加密，在密钥对中，其中一个密钥是对外公开的，所有人都可以获取到，
        称为公钥，其中一个密钥是不公开的称为私钥。
    8.非对称加密算法对加密内容的长度有限制，不能超过公钥长度。比如现在常用的公钥长度是 2048 位，意味着待加密内容不能超过 256 个字节。
    9.摘要算法
        数字摘要是采用单项Hash函数将需要加密的明文“摘要”成一串固定长度（128位）的密文，这一串密文又称为数字指纹，它有固定的长度，而且不同的明文摘要成密文，
        其结果总是不同的，而同样的明文其摘要必定一致。“数字摘要“是https能确保数据完整性和防篡改的根本原因。
    10.数字签名
        数字签名技术就是对“非对称密钥加解密”和“数字摘要“两项技术的应用，它将摘要信息用发送者的私钥加密，与原文一起传送给接收者。接收者只有用发送者的公钥才能解密被加密的摘要信息，
        然后用HASH函数对收到的原文产生一个摘要信息，与解密的摘要信息对比。如果相同，则说明收到的信息是完整的，在传输过程中没有被修改，否则说明信息被修改过，
        因此数字签名能够验证信息的完整性。
        数字签名的过程如下：
        明文 --> hash运算 --> 摘要 --> 私钥加密 --> 数字签名
    11.数字签名有两种功效：
        一、能确定消息确实是由发送方签名并发出来的，因为别人假冒不了发送方的签名。
        二、数字签名能确定消息的完整性。
        注意：
        数字签名只能验证数据的完整性，数据本身是否加密不属于数字签名的控制范围
    12.数字证书
        为什么要有数字证书？
        对于请求方来说，它怎么能确定它所得到的公钥一定是从目标主机那里发布的，而且没有被篡改过呢？亦或者请求的目标主机本本身就从事窃取用户信息的不正当行为呢？这时候，
        我们需要有一个权威的值得信赖的第三方机构(一般是由政府审核并授权的机构)来统一对外发放主机机构的公钥，只要请求方这种机构获取公钥，就避免了上述问题的发生。
    13.数字证书的颁发过程
        用户首先产生自己的密钥对，并将公共密钥及部分个人身份信息传送给认证中心。认证中心在核实身份后，将执行一些必要的步骤，以确信请求确实由用户发送而来，然后，
        认证中心将发给用户一个数字证书，该证书内包含用户的个人信息和他的公钥信息，同时还附有认证中心的签名信息(根证书私钥签名)。用户就可以使用自己的数字证书进行相关的各种活动。
        数字证书由独立的证书发行机构发布，数字证书各不相同，每种证书可提供不同级别的可信度。
    14.证书包含哪些内容
        证书颁发机构的名称
        证书本身的数字签名
        证书持有者公钥
        证书签名用到的Hash算法
        验证证书的有效性
        浏览器默认都会内置CA根证书，其中根证书包含了CA的公钥
    15.证书颁发的机构是伪造的：浏览器不认识，直接认为是危险证书
        证书颁发的机构是确实存在的，于是根据CA名，找到对应内置的CA根证书、CA的公钥。用CA的公钥，对伪造的证书的摘要进行解密，发现解不了,认为是危险证书.
        对于篡改的证书，使用CA的公钥对数字签名进行解密得到摘要A,然后再根据签名的Hash算法计算出证书的摘要B，对比A与B，若相等则正常，若不相等则是被篡改过的。
        证书可在其过期前被吊销，通常情况是该证书的私钥已经失密。较新的浏览器如Chrome、Firefox、Opera和Internet Explorer都实现了在线证书状态协议（OCSP）
        以排除这种情形：浏览器将网站提供的证书的序列号通过OCSP发送给证书颁发机构，后者会告诉浏览器证书是否还是有效的。
        1、2点是对伪造证书进行的。3是对于篡改后的证书验证，4是对于过期失效的验证。
    16.SSL 与 TLS
        SSL (Secure Socket Layer，安全套接字层)
        SSL为Netscape所研发，用以保障在Internet上数据传输之安全，利用数据加密(Encryption)技术，可确保数据在网络上之传输过程中不会被截取，当前为3。0版本。
        SSL协议可分为两层： SSL记录协议（SSL Record Protocol）：它建立在可靠的传输协议（如TCP）之上，为高层协议提供数据封装、压缩、加密等基本功能的支持。 SSL握手协议（SSL Handshake Protocol）：它建立在SSL记录协议之上，用于在实际的数据传输开始前，通讯双方进行身份认证、协商加密算法、交换加密密钥等。
    17.TLS (Transport Layer Security，传输层安全协议)
        用于两个应用程序之间提供保密性和数据完整性。
        TLS 1.0是IETF（Internet Engineering Task Force，Internet工程任务组）制定的一种新的协议，它建立在SSL 3.0协议规范之上，是SSL 3.0的后续版本，可以理解为SSL 3.1，
        它是写入了 RFC 的。该协议由两层组成： TLS 记录协议（TLS Record）和 TLS 握手协议（TLS Handshake）。较低的层为 TLS 记录协议，位于某个可靠的传输协议（例如 TCP）上面。
    18.SSL/TLS协议作用：
        认证用户和服务器，确保数据发送到正确的客户机和服务器；
        加密数据以防止数据中途被窃取；
        维护数据的完整性，确保数据在传输过程中不被改变。
    19.TLS比SSL的优势
        对于消息认证使用密钥散列法：TLS 使用“消息认证代码的密钥散列法”（HMAC），当记录在开放的网络（如因特网）上传送时，该代码确保记录不会被变更。SSLv3.0还提供键控消息认证，
        但HMAC比SSLv3.0使用的（消息认证代码）MAC 功能更安全。
        增强的伪随机功能（PRF）：PRF生成密钥数据。在TLS中，HMAC定义PRF。PRF使用两种散列算法保证其安全性。如果任一算法暴露了，只要第二种算法未暴露，则数据仍然是安全的。
        改进的已完成消息验证：TLS和SSLv3.0都对两个端点提供已完成的消息，该消息认证交换的消息没有被变更。然而，TLS将此已完成消息基于PRF和HMAC值之上，这也比SSLv3.0更安全。
        一致证书处理：与SSLv3.0不同，TLS试图指定必须在TLS之间实现交换的证书类型。
        特定警报消息：TLS提供更多的特定和附加警报，以指示任一会话端点检测到的问题。TLS还对何时应该发送某些警报进行记录。
    20.SSL、TLS的握手过程
        SSL与TLS握手整个过程如下图所示，下面会详细介绍每一步的具体内容：
        https握手流程图
    21.客户端首次发出请求
        由于客户端(如浏览器)对一些加解密算法的支持程度不一样，但是在TLS协议传输过程中必须使用同一套加解密算法才能保证数据能够正常的加解密。在TLS握手阶段，
        客户端首先要告知服务端，自己支持哪些加密算法，所以客户端需要将本地支持的加密套件(Cipher Suite)的列表传送给服务端。除此之外，客户端还要产生一个随机数，
        这个随机数一方面需要在客户端保存，另一方面需要传送给服务端，客户端的随机数需要跟服务端产生的随机数结合起来产生后面要讲到的 Master Secret 。
    客户端需要提供如下信息：
        - 支持的协议版本，比如TLS 1.0版
        - 一个客户端生成的随机数，稍后用于生成”对话密钥”
        - 支持的加密方法，比如RSA公钥加密
        - 支持的压缩方法
    服务端首次回应
    服务端在接收到客户端的Client Hello之后，服务端需要确定加密协议的版本，以及加密的算法，然后也生成一个随机数，以及将自己的证书发送给客户端一并发送给客户端。这里的随机数是整个过程的第二个随机数
    
    服务端需要提供的信息：
    - 协议的版本
    - 加密的算法
    - 随机数
    - 服务器证书
    
    客户端再次回应
    客户端首先会对服务器下发的证书进行验证，验证通过之后，则会继续下面的操作，客户端再次产生一个随机数（第三个随机数），然后使用服务器证书中的公钥进行加密，以及放一个ChangeCipherSpec消息即编码改变的消息，还有整个前面所有消息的hash值，进行服务器验证，然后用新秘钥加密一段数据一并发送到服务器，确保正式通信前无误。
    客户端使用前面的两个随机数以及刚刚新生成的新随机数，使用与服务器确定的加密算法，生成一个Session Secret。
    
    ChangeCipherSpec
    ChangeCipherSpec是一个独立的协议，体现在数据包中就是一个字节的数据，用于告知服务端，客户端已经切换到之前协商好的加密套件（Cipher Suite）的状态，准备使用之前协商好的加密套件加密数据并传输了。
    
    服务器再次响应
    服务端在接收到客户端传过来的第三个随机数的 加密数据之后，使用私钥对这段加密数据进行解密，并对数据进行验证，也会使用跟客户端同样的方式生成秘钥，一切准备好之后，也会给客户端发送一个 ChangeCipherSpec，告知客户端已经切换到协商过的加密套件状态，准备使用加密套件和 Session Secret加密数据了。之后，服务端也会使用 Session Secret 加密一段 Finish 消息发送给客户端，以验证之前通过握手建立起来的加解密通道是否成功。
    
    之后的客户端与服务器间通信
    确定秘钥之后，服务器与客户端之间就会通过商定的秘钥加密消息了，进行通讯了。整个握手过程也就基本完成了。
    
    值得特别提出的是：
    SSL协议在握手阶段使用的是非对称加密，在传输阶段使用的是对称加密，也就是说在SSL上传送的数据是使用对称密钥加密的！因为非对称加密的速度缓慢，耗费资源。其实当客户端和主机使用非对称加密方式建立连接后，客户端和主机已经决定好了在传输过程使用的对称加密算法和关键的对称加密密钥，由于这个过程本身是安全可靠的，也即对称加密密钥是不可能被窃取盗用的，因此，保证了在传输过程中对数据进行对称加密也是安全可靠的，因为除了客户端和主机之外，不可能有第三方窃取并解密出对称加密密钥！如果有人窃听通信，他可以知道双方选择的加密方法，以及三个随机数中的两个。整个通话的安全，只取决于第三个随机数（Premaster secret）能不能被破解。
    
    其他补充
    对于非常重要的保密数据，服务端还需要对客户端进行验证，以保证数据传送给了安全的合法的客户端。服务端可以向客户端发出 Cerficate Request 消息，要求客户端发送证书对客户端的合法性进行验证。比如，金融机构往往只允许认证客户连入自己的网络，就会向正式客户提供USB密钥，里面就包含了一张客户端证书。
    
    PreMaster secret前两个字节是TLS的版本号，这是一个比较重要的用来核对握手数据的版本号，因为在Client Hello阶段，客户端会发送一份加密套件列表和当前支持的SSL/TLS的版本号给服务端，而且是使用明文传送的，如果握手的数据包被破解之后，攻击者很有可能串改数据包，选择一个安全性较低的加密套件和版本给服务端，从而对数据进行破解。所以，服务端需要对密文中解密出来对的PreMaster版本号跟之前Client Hello阶段的版本号进行对比，如果版本号变低，则说明被串改，则立即停止发送任何消息。
    
    session的恢复
    有两种方法可以恢复原来的session：一种叫做session ID，另一种叫做session ticket。
    
    session ID
    session ID的思想很简单，就是每一次对话都有一个编号（session ID）。如果对话中断，下次重连的时候，只要客户端给出这个编号，且服务器有这个编号的记录，双方就可以重新使用已有的”对话密钥”，而不必重新生成一把。
    
    session ID是目前所有浏览器都支持的方法，但是它的缺点在于session ID往往只保留在一台服务器上。所以，如果客户端的请求发到另一台服务器，就无法恢复对话
    
    session ticket
    客户端发送一个服务器在上一次对话中发送过来的session ticket。这个session ticket是加密的，只有服务器才能解密，其中包括本次对话的主要信息，比如对话密钥和加密方法。当服务器收到session ticket以后，解密后就不必重新生成对话密钥了。
    
    目前只有Firefox和Chrome浏览器支持。

## 8 通过socket进行TCP通信丢包原因总结

    今天在公司问老大，公司的项目底层，是使用的TCP，因为可靠，自动断线重连，在底层都实现了，但是我记得TCP也会有掉包的问题，所以这文章就诞生了——关于TCP掉包的问题，TCP是基于不可靠的网络实现可靠的传输，肯定也会存在掉包的情况。
        如果通信中发现缺少数据或者丢包，那么，最大的可能在于程序发送的过程或者接收的过程出现问题。
        例如服务器给客户端发大量数据，Send的频率很高，那么就有可能在Send时发生错误（原因可能是又多种，可能是程序处理逻辑问题，多线程同步问题，缓冲区溢出问题等等），
        如果没有对Send失败做处理重发数据，那么客户端收到的数据就会比理论应该收到的少，就会造成丢数据，丢包的现象。
        这种现象，其实本质上来说不是丢包，也不是丢数据，只是因为程序处理有错误，导致有些数据没有成功地被socket发送出去。
        常用的解决方法如下：拆包、加包头、发送，组合包，如果客户端、服务端掉线，常采用心跳测试。
    tcp是一个“流”的协议，一个完整的包可能会被TCP拆分成多个包进行发送，也可能把小的封装成一个大的数据包发送，这就是所谓的TCP粘包和拆包问题。
    粘包、拆包问题说明
    假设客户端分别发送数据包D1和D2给服务端，由于服务端一次性读取到的字节数是不确定的，所以可能存在以下4种情况。
    1.服务端分2次读取到了两个独立的包，分别是D1,D2,没有粘包和拆包；
    2.服务端一次性接收了两个包，D1和D2粘在一起了，被成为TCP粘包;
    3.服务端分2次读取到了两个数据包，第一次读取到了完整的D1和D2包的部分内容,第二次读取到了D2包的剩余内容，这被称为拆包；
    4.服务端分2次读取到了两个数据包，第一次读取到了部分D1，第二次读取D1剩余的部分和完整的D2包；
    如果此时服务端TCP接收滑动窗非常小,而数据包D1和D2都很大，很有可能发送第五种可能，即服务端多次才能把D1和D2接收完全，期间多次发生拆包情况。（TCP接收滑动窗：是接收端的大小，随着流量大小而变化，如果我的解释还不明确，请读者自行百度，或者查阅《计算机网络》、《TCP/IP》中TCP的内容）
    粘包问题的解决策略
    由于底层的TCP无法理解上层的业务逻辑，所以在底层是无法确保数据包不被拆分和重组的，这个问题只能通过上层的应用协议栈设计来解决，根据业界的主流协议的解决方案，归纳如下：
    1.消息定长，例如每个报文的大小为固定长度200字节,如果不够，空位补空格；
    2.在包尾增加回车换行符进行分割，例如FTP协议；
    3.将消息分为消息头和消息体，消息头中包含表示消息总长度（或者消息体长度）的字段，通常设计思路是消息头的第一个字段用int来表示消息的总长度；（我之前linux C开发，就用的这种）。
    4.更复杂的应用层协议；
