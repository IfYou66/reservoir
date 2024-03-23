function getMenu() {
    return [
        {href: "page/realtime/introduction.html", icon: 'layui-icon-list', name: '水库简介', sub: []},
        {href: "page/realtime/realtime.html", icon: 'layui-icon-light', name: '实时状态', sub: []},
        {
            href: "", icon: 'layui-icon-app', name: '常规监测', sub: [
                {href: "page/inspect/realtime_data.html", icon: '', name: '实时数据', sub: []},
                {href: "page/inspect/history_data.html", icon: '', name: '历史数据', sub: []},
                {href: "page/inspect/manual_check.html", icon: '', name: '人工校核', sub: []},
                {
                    href: "", icon: '', name: '巡检管理', sub: [
                        {href: "page/special/heihushan/manual_inspect.html", icon: '', name: '人工巡检', sub: []},
                       
                        {href: "page/special/heihushan/flight_inspect.html", icon: '', name: '无人机巡检', sub: []},
                    ]
                }
            ]
        },
        {
            href: "", icon: 'layui-icon-link', name: '安全监测', sub: [
                {
                    href: "page/inspect/realtime_data.html", icon: '', name: '大坝安全', sub: [
                        {href: "page/safe/dam_transform.html", icon: '', name: '变形监测', sub: []},
                        {href: "page/safe/dam_seepage.html", icon: '', name: '实时渗流', sub: []},
                        {href: "page/safe/dam_history.html", icon: '', name: '历史渗流', sub: []},
                        {href: "page/safe/dam_landSlide.html", icon: '', name: '滑坡监测', sub: []},
                    ]
                },
                {
                    href: "page/inspect/history_data.html", icon: '', name: '溢洪闸安全', sub: [
                        {href: "page/safe/gate_displacement.html", icon: '', name: '位移监测', sub: []},
                        {href: "page/safe/gate_declination.html", icon: '', name: '倾斜监测', sub: []},
                    ]
                },
                {
                    href: "", icon: '', name: '放水洞安全', sub: [
                        {href: "#", icon: '', name: '振动监测', sub: []},
                        {href: "#", icon: '', name: '实时渗流', sub: []},
                    ]
                }
            ]
        },
        {
            href: "", icon: 'layui-icon-chart-screen', name: '安全分析', sub: [
                {
                    href: "page/inspect/realtime_data.html", icon: '', name: '坝体分析', sub: [
                        {href: "page/analysis/dam_seepage.html", icon: '', name: '渗流及渗透稳定计算', sub: []},
                        {href: "page/analysis/dam_stable.html", icon: '', name: '坝体稳定计算', sub: []},
                    ]
                },
                {
                    href: "page/inspect/history_data.html", icon: '', name: '溢洪道分析', sub: [
                        {href: "page/analysis/gate_building.html", icon: '', name: '控制建筑物分析', sub: []},
                        {href: "page/analysis/gate_wall.html", icon: '', name: '翼墙稳定分析', sub: []},
                    ]
                },
                {
                    href: "", icon: '', name: '放水洞分析', sub: [
                        {href: "page/analysis/tunnel_control.html", icon: '', name: '控制闸稳定分析', sub: []},
                    ]
                },
            ]
        },
        {
            href: "", icon: 'layui-icon-water', name: '洪水预报', sub: [
                {href: "#", icon: '', name: '控制流域与雨量分布', sub: []},
                {href: "#", icon: '', name: '入库洪水分析', sub: []},
                {href: "#", icon: '', name: '水库调洪预算', sub: []},
                {href: "#", icon: '', name: '下游淹没分析', sub: []},
                {href: "#", icon: '', name: '下闸蓄水时刻分析', sub: []},
            ]
        },
        {
            href: "", icon: 'layui-icon-util', name: '供水调度', sub: [
                {href: "#", icon: '', name: '工业供水', sub: []},
                {href: "#", icon: '', name: '城市供水', sub: []},
                {href: "page/supply/agriculture.html", icon: '', name: '农业灌溉', sub: []},
                {href: "page/supply/ecology.html", icon: '', name: '生态供水', sub: []},
            ]
        },
        {href: "page/video/view.html", icon: 'layui-icon-camera', name: '视频监控', sub: []},
        {
            href: "", icon: 'layui-icon-read', name: '电子档案', sub: [
                {href: "page/document/register.html", icon: '', name: '注册登记表', sub: []},
                {href: "page/document/heihushanarchive.html", icon: '', name: '历史档案', sub: []},
                {href: "page/document/dispatcher.html", icon: '', name: '防洪调度', sub: []},
                {href: "page/document/plan.html", icon: '', name: '计划管理', sub: []},
            ]
        },
    ]
}

