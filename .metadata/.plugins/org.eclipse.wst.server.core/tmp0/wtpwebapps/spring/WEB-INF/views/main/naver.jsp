<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>NAVER</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/naver.css">
	<script src="<%= request.getContextPath() %>/resources/js/jquery.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/naver.js"></script>
	<script src="<%= request.getContextPath() %>/resources/js/rolling.js"></script>
	<script>
		$(function(){
			$('.icon-auto-search').click(function(){
				console.log('.icon-auto-search-open');
			})
		})
	</script>
</head>
<body>
	<div class="box-whale">
		<div class="container">
			<a href="#" class="link-whale">
				<i class="icon-whale bg-44265f"></i>
				<img class="img-banner-whale" width="150px" height="auto" src="https://s.pstatic.net/static/www/img/uit/2020/img_whale_banner.483e9e.png" alt="네이버 웨일 배너">
				<p class="text-whale">
					인터넷의 새로운 시작! 
					<span class="text-underline">네이버웨일</span>
					로 차원이 다른 웹서핑을 경험해보세요!
					<button class="whale-btn-download">다운로드</button>
				</p>
				<button class="btn-close-whale">3일 동안 보지 않기</button>
			</a>
		</div>
	</div>
	<!-- 네이버 로고 -->
	<div class="box-container-search">
		<div class="container">
			<div class="logo-area">
				<h1 class="logo-defualt">
					<a href="//www.naver.com" class="logo-naver bg-44265f"></a>
				</h1>
			</div>
			<!-- 검색어 입력창 -->
			<div class="search-area">
				<input type="text" id="input-text" title="검색어 입력">
				<a href="#" class="btn-v-keyboard">
					<i class="icon-v-keyboard bg-44265f"></i>
					<!-- 한글 입력도구 -->
					<p class="msg-keyboard bg-44265f"><span class="blind">입력도구</span></p>
				</a>
				<!-- 오토서치 -->
				<a href="#" class="btn-auto-search">
					<i class="icon-auto-search bg-44265f"></i>
					<i class="con-auto-search-open bg-44265f"></i>
					<span class="blind-text"></span>
				</a>
				<button class="btn-search">
					<i class="icon-search bg-44265f"></i>
				</button>
				<div class="box-auto-box display-none">
					<div class="box-auto-up">
						현재 자동완성 기능을 사용하고 계십니다.
					</div>
					<div class="box-auto-down ">
						<span class="auto-l">
							<a href="#" class="link-help">도움말</a>
							<span class="auto-bar"></span>
							<a href="#" class="link-report">신고</a>
						</span>
						<span class="auto-r">
							<a href="#" class="link-auto-close">자동완성 끄기</a>
						</span>
					</div>
				</div>
			</div>
		
			<!-- 서브메뉴 -->
			<div class="box-container-service">
				<a href="#" class="link-set">
					네이버를 시작페이지로
				</a>
				<i class="icon-service-bar"></i>
				<a href="#" class="link-jr">
					<i class="icon-jr bg-44265f"></i>
				</a>
				<a href="#" class="link-happybean">
					<i class="icon-happybean bg-44265f"></i>
				</a>
		</div>
	</div>
</div>
<!-- 메뉴 -->
	<div class="box-container-menu">
		<div class="container">
			<div class="group-menu">
				<ul class="list-green-menu">
					<li class="nav-item">
						<a href="//www.mail.naver.com" class="nav"><i class="icon-mail bg-44265f"></i>메일</a></li>
					<li class="nav-item"><a href="//section.cafe.naver.com/" class="nav">카페</a></li>
					<li class="nav-item"><a href="//section.blog.naver.com/" class="nav">블로그</a></li>
					<li class="nav-item"><a href="//kin.naver.com/" class="nav">지식iN</a></li>
					<li class="nav-item"><a href="//shoping.naver.com/" class="nav">쇼핑</a></li>
					<li class="nav-item"><a href="//order.pay.naver.com/home" class="nav">Pay</a></li>
					<li class="nav-item">
						<a href="//tv.naver.com" class="nav">
							<i class="icon-TV bg-44265f"></i>
							TV
						</a>
					</li>
				</ul>
				<ul class="list-center-menu">
					<li class="nav-item"><a href="#" class="nav">사전</a></li>
					<li class="nav-item"><a href="#" class="nav">뉴스</a></li>
					<li class="nav-item"><a href="#" class="nav">증권</a></li>
					<li class="nav-item"><a href="#" class="nav">부동산</a></li>
					<li class="nav-item"><a href="#" class="nav">지도</a></li>
					<li class="nav-item"><a href="#" class="nav">영화</a></li>
					<li class="nav-item"><a href="#" class="nav">뮤직</a></li>
					<li class="nav-item"><a href="#" class="nav">책</a></li>
					<li class="nav-item"><a href="#" class="nav">웹툰</a></li>
				</ul>
				<a href="#" class="btn-more">더보기</a>
				<a href="#" class="btn-more fold display-none">접기</a>
			</div>
			<div class="box-group-keyword">
				<a href="#" class="btn-keyword">
					<i class="icon-error bg-44265f"></i>
					<span class="text-keyword">검색어 필터 설정이 필요합니다</span>
				</a>
			</div>
			<div class="box-service-menu display-none">
				<a href="" class="link-service-more">서비스 전체보기</a>
				<a href="" class="btn-menu-set">메뉴 설정</a>
			</div>
		</div>
	</div>
	<div class="ly-service display-none ">
		<div class="group-service">
			<dl class="list-service">
				<dt class="service-title">ㄱ-ㄷ</dt>
				<dd class="service-data"><a href="#">그라폴리오</a></dd>
				<dd class="service-data"><a href="#">날씨</a></dd>
				<dd class="service-data"><a href="#">네이버 예약</a></dd>
				<dd class="service-data"><a href="#">네이버 클라우드</a></dd>
				<dd class="service-data"><a href="#">네이버 포스트</a></dd>
				<dd class="service-data"><a href="#">뉴스</a></dd>
				<dd class="service-data"><a href="#">데이터 랩</a></dd>
			</dl>
			<dl class="list-service">
				<dt class="service-title">ㄹ-ㅅ</dt>
				<dd class="service-data"><a href="#">만화</a></dd>
				<dd class="service-data"><a href="#">메모</a></dd>
				<dd class="service-data"><a href="#">뮤직</a></dd>
				<dd class="service-data"><a href="#">밴드</a></dd>
				<dd class="service-data"><a href="#">부동산</a></dd>
				<dd class="service-data"><a href="#">북마크</a></dd>
				<dd class="service-data"><a href="#">소프트웨어</a></dd>
				<dd class="service-data"><a href="#">스포츠</a></dd>
				<dd class="service-data"><a href="#">시리즈</a></dd>
				<dd class="service-data"><a href="#">시리즈on</a></dd>
			</dl>
			<dl class="list-service">
				<dt class="service-title">ㅇ-ㅈ</dt>
				<dd class="sevice-data"><a href="#">영화</a></dd>
				<dd class="sevice-data"><a href="#">오디오클립</a></dd>
				<dd class="sevice-data"><a href="#">오피스</a></dd>
				<dd class="sevice-data"><a href="#">웹소설</a></dd>
				<dd class="sevice-data"><a href="#">자동차</a></dd>
				<dd class="sevice-data"><a href="#">주소록</a></dd>
				<dd class="sevice-data"><a href="#">증권(금융)</a></dd>
				<dd class="sevice-data"><a href="#">지도</a></dd>
				<dd class="sevice-data"><a href="#">지식백과</a></dd>
			</dl>
			<dl class="list-service">
				<dt class="service-title">ㅊ-ㅎ</dt>
				<dd class="sevice-data"><a href="#">책</a></dd>
				<dd class="sevice-data"><a href="#">캘린더</a></dd>
				<dd class="sevice-data"><a href="#">학술정보</a></dd>
				<dd class="sevice-data"><a href="#">항공권</a></dd>
				<dd class="sevice-data"><a href="#">호텔</a></dd>
			</dl>
			<dl class="list-service">
				<dt class="service-title">A-Z</dt>
				<dd class="sevice-data"><a href="#">modoo![모두]</a></dd>
				<dd class="sevice-data"><a href="#">MY구독</a></dd>
				<dd class="sevice-data"><a href="#">PC게임</a></dd>
				<dd class="sevice-data"><a href="#">TV연예</a></dd>
				<dd class="sevice-data"><a href="#">V LIVE</a></dd>
			</dl>
			<dl class="list-service">
				<dt class="service-title">사전</dt>
				<dd class="sevice-data"><a href="#">사전</a></dd>
				<dd class="sevice-data"><a href="#">국어사전</a></dd>
				<dd class="sevice-data"><a href="#">영어/영영사전</a></dd>
				<dd class="sevice-data"><a href="#">일본어사전</a></dd>
				<dd class="sevice-data"><a href="#">중국어사전</a></dd>
				<dd class="sevice-data"><a href="#">한자사전</a></dd>
				<dd class="sevice-data"><a href="#" class="link-dlc">사전 더보기</a></dd>
				
			</dl>
			<dl class="list-service">
				<dt class="service-title">인기/신규 서비스</dt>
				<dd class="sevice-data"><a href="#">네이버플러스 멤버십</a></dd>
				<dd class="sevice-data"><a href="#">클로바더빙</a></dd>
				<dd class="sevice-data"><a href="#">인플루언서 검색</a></dd>
				<dd class="sevice-data"><a href="#">Keep</a></dd>
				<dd class="sevice-data"><a href="#">VIBE</a></dd>
				<dd class="sevice-data"><a href="#">웨일</a></dd>
				<dd class="sevice-data"><a href="#">파파고</a></dd>
			</dl>
		</div>
	</div>
	<div class="container set display-none">
		<div class="box-list-service">
			<div class="box-service-title">ㄱ-ㄷ</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>그라폴리오</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>날씨</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버 예약</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버 클라우드</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버 포스트</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>뉴스</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>데이터랩</div>
		</div>
		<div class="box-list-service">
			<div class="box-service-title">ㄹ-ㅅ</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>만화/웹툰</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>메모</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>뮤직</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>밴드</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>부동산</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>북마크</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>소프트웨어</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>스포츠</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>시리즈</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>시리즈on</div>
		</div>
		<div class="box-list-service">
			<div class="box-service-title">ㅇ-ㅈ</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>영화</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>오디오클립</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>오피스</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>웹소설</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>자동차</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>주소록</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>증권(금융)</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>지도</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>지식백과</div>
		</div>
		<div class="box-list-service">
			<div class="box-service-title">ㅊ-ㅎ</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>책</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>캘린더</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>학술정보</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>항공권</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>호텔</div>
		</div>
		<div class="box-list-service">
			<div class="box-service-title">A-Z</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>modoo![모두]</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>MY구독</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>PC게임</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>TV연애</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>V LIVE</div>
		</div>
		<div class="box-list-service">
			<div class="box-service-title">사전</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>사전</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>국어사전</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>영어/영영사전</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>일본어사전</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>중국어사전</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>한자사전</div>
		</div>
		<div class="box-list-service">
			<div class="box-service-title">인기/신규 서비스</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>네이버플러스</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>클로바더빙</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>인플루언서 검색</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>Keep</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>VIBE</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>웨일</div>
			<div class="box-serivce-check"><input type="checkbox" name="" value=""><i class="icon-check bg-44265f"></i>파파고</div>
		</div>
	</div>
</div>
</div>
<div class="box-container-contents">
<div class="container">
	<div class="box-left">
		<div class="box-left1">
			<a href="#">
				<img width="750px" height="135px" src="https://ssl.pstatic.net/tveta/libs/1282/1282740/b7de4ced147a82421056_20200618185424423.jpg" alt="">
			</a>
		</div>
		<div class="box-left2">
			<div class="box-issue-area">
				<a href="#" class="link-media">연합뉴스</a>
				<div class="box-rolling-newslist">
					<a href="#" class="box-rolling-news">이재명 "정부 2차 재난지원금 어려우면 도 차원 추가지원 검토"</a>
					<a href="#" class="box-rolling-news">6·25 국군유해 147구 70년만에 조국으로…북한→하와이→한국</a>
					<a href="#" class="box-rolling-news">김정은, 대남 군사행동계획 보류…중앙군사위 예비회의서 결정</a>
					<a href="#" class="box-rolling-news">고개 숙인 강정호…국내 복귀 여부, 키움의 최종 선택만 남았다 </a>
					<a href="#" class="box-rolling-news">"집단 감염 러시아 화물선 前선장 고열로 1주일 전 하선" </a>
				</div>
			</div>
			<div class="box-direct-area">
				<a href="#" class="link-news">네이버뉴스</a>
				<a href="#" class="link-direct">연예</a>
				<a href="#" class="link-direct">스포츠</a>
				<a href="#" class="link-direct">경제</a>
			</div>
		</div>
		<!-- 뉴스 스탠드 -->
		<div class="news-stand">
			<a href="//newsstand.naver.com" class="link-news-stand"> 뉴스 스탠드</a>
			<div class="sort-area">
				<a href="#" role="button" class="btn-sort">구독한 언론사</a>
				<a href="#" role="button" class="btn-sort sort-on">전체 언론사</a>
			</div>
			<div class="set-area">
				<a href="#" class="btn-set">
					<i class="icon-list"></i>
				</a>
				<a href="#" class="btn-set btn-set-on">
					<i class="icon-tile"></i>
				</a>
				<a href="#" class="btn-set not">
					<div class="icon-set"></div>
				</a>
			</div>
		</div>
		<!-- 그룹 뉴스 -->
		<div class="group-news">
			<a class="btn-prev"><i class="icon-btn bg-44265f "></i></a>
			<a class="btn-next"><i class="icon-btn bg-44265f"></i></a>
			<div class="line-row1"></div>
			<div class="line-row2"></div>
			<div class="line-row3"></div>
			<div class="line-col1"></div>
			<div class="line-col2"></div>
			<div class="line-col3"></div>
			<div class="line-col4"></div>
			<div class="line-col5"></div>
			<div class="line-col6"></div>
			<div class="line-col7"></div>
			<div class="box-row">
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/038.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/032.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/073.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/076.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/092.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/023.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
			</div>
			<div class="box-row">
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/030.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/047.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/109.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/368.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/417.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/948.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
			</div>
			<div class="box-row">
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/923.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/924.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/964.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/993.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/922.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/809.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
			</div>
			<div class="box-row">
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/823.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/410.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/963.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/958.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/311.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
				<div class="box-thumb-area">
					<img height="20px" src="https://s.pstatic.net/static/newsstand/2020/logo/light/0604/944.png" alt="">
					<div class="box-thumb display-none">
						<a href="#" class="btn-subs">구독</a>
						<a href="#" class="btn-view">기사보기</a>
					</div>
				</div>
			</div>	
		</div>
		<div class="container-themecast">
			<div class="box-theme-cast">
				<div class="theme-head">
					<div class="group-title">
						<div class="title-area">
							<strong class="title">오늘 읽을만한 글</strong>
							<span class="dsc">주제별로 분류된 다양한 글 모음</span>
						</div>
						<div class="info-area">
							<span class="info">
								<strong class="new">2,185</strong>개의 글</span>
							<a href="#" class="info-btn-set">관심주제 설정</a>
						</div>
					</div>
					<div class="theme-fix-wrap">
						<div class="group-category">
							<div class="main-category">
								<a href="" class="pm-btn-prev">
									<i class="pm-icon-prev bg-44265f"></i>
								</a>
								<a href="" class="pm-btn-next">
									<i class="pm-icon-next bg-44265f"></i>
								</a>
								<div class="category-box1">
									<div class="category-box2">
										<ul class="list-category">
											<li class="category-item">
												<a href="#" class="tab id-enter" aria-selected="true" data-target="enter">엔터</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-sport" aria-selected="false" data-target="sports">스포츠</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-car" aria-selected="false" data-target="car">자동차</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-webtoon" aria-selected="false" data-target="webtoon">웹툰</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-economy" aria-selected="false" data-target="economy">경제M</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-food" aria-selected="false" data-target="food">푸드</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-game" aria-selected="false" data-target="game">게임</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-movie" aria-selected="false" data-target="movie">영화</a>
											</li>
											<!-- ========================================================== -->
											<li class="category-item">
												<a href="#" class="tab id-tech">테크</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-science">과학</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-job">JOB&</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-trip">여행+</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-marry">연애·결혼</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-bookcul">책문화</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-health">건강</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-riving">리빙</a>
											</li>
										<!-- ============================================================ -->
											<li class="category-item">
												<a href="#" class="tab id-business">비즈니스</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-law">법률</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-fashion">패션뷰티</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-animal">동물공감+</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-design">디자인</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-china">중국</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-show">공연전시</a>
											</li>
											<li class="category-item">
												<a href="#" class="tab id-farm">FARM</a>
											</li>	
										 <!--================================================= --> 
										 <li class="category-item">
											<a href="#" class="tab id-parents">부모i</a>
										</li>
										<li class="category-item">
											<a href="#" class="tab id-together">함께N</a>
										</li>
										<li class="category-item">
											<a href="#" class="tab id-school">스쿨잼</a>
										</li>	
										</ul>
									</div>
								</div>
							</div>
						</div>
				</div>
			</div>
			</div>
			<div class="box-theme-body">
				<div class="box-body enter">엔터</div>
				<div class="box-body sports">스포츠</div>
				<div class="box-body car">자동차</div>
				<div class="box-body webtoon">웹툰</div>
				<div class="box-body economy">경제M</div>
				<div class="box-body food">푸드</div>
				<div class="box-body game">게임</div>
				<div class="box-body movie">영화</div>
			</div>
		</div>
	</div>
	<div class="box-right">
		<div class="box-login">
			<p class="login-msg">네이버를 더 안전하고 편리하게 이용하세요</p>
			<a href="href=https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com" class="link-login">
			<i class="icon-naver bg-44265f"></i>로그인</a>
			<div class="sub-area">
				<div class="look-box">
					<a href="https://nid.naver.com/user/help.nhn?todo=idinquiry" class="link-look">아이디</a>
					<a href="href=https://nid.naver.com/nidreminder.form" class="link-look2">비밀번호 찾기</a>
				</div>
				<a href="https://nid.naver.com/nidregister.form?url=https%3A%2F%2Fwww.naver.com" class="link-join">
					회원가입
				</a>
			</div>
		</div>
		<div class="timesquare">
			<div class="card-wrap">
				<div class="card-nav">
					<a href="#" class="btn-nav-prev"></a>
					<a href="#" class="btn-nav-next"></a>
				</div>
				<div style="height: 100%;" class="box-rolling-wrap">
					<div class="rolling-view-port">
						<div class="rolling-camera">
							<div class="rolling-panel">
								<a href="#" class="card-news card">
									<i class="badge-news">이슈</i>
									<span class="text-news">코로나바이러스감염증19 현황</span>
								</a>
								<a href="#" class="card-weather card">
									<i class="img-weather bg-44265f"></i>
									<div class="box-current">
										<strong class="text-current">23.2°</strong>
										<strong class="text-state">흐림</strong>
									</div>
									<div class="box-degree">
										<span class="max" style="color: #e9564a;">25.0°</span>
										<span class="min" style="color: #2586ee;">21.0°</span>
									</div>
									<div class="box-location">서초동</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="box-ad">
			<a href="https://blog.naver.com/luckeyword/222012040861">
			<img src="../naver/049f42c94d1166ce42b5_20200626180634860.png" style="width: 350px; height: 200px;">
			</a>
		</div>
		<!-- 쇼핑 탭 -->
		<div class="shop-cast">
			<div class="shop-wrap">
				<div class="shop-header">
					<h1 class="link-shop">
						<a class="shop" href="http://shopping.naver.com/">쇼핑</a>
					</h1>
					<ul class="shop-tab">
						<li class="tab-item product">
							<a href="#" class="tab" aria-selected="true" title="상품은 광고영역입니다." data-target="product">
								상품
							</a>
						</li>
						<li class="tab-item mall">
							<a href="#" class="tab" aria-selected="false" title="쇼핑몰은 광고영역입니다." data-target="mall">
							쇼핑몰
							</a>
						</li>
						<li class="tab-item men">
							<a href="#" class="tab" aria-selected="false" title="MEN은 광고영역입니다." data-target="MEN">
								MEN
							</a>
						</li>
					</ul>
				</div>
				<div class="shop-contents">
					<div class="group-shop product MEN">
						<div class="box-head">
							<div class="head-area">
								<a href="#">G마켓</a><span class="ls9"></span>
								<a href="#">옥션</a><span class="ls9"></span>
								<a href="#">11번가</a><span class="ls9"></span>
								<a href="#">위메프</a><span class="ls9"></span>
								<a href="#">티몬</a><span class="ls9"></span>
								<a href="#">이마트몰</a>
							</div>
							<div class="head-area">
								<a href="#">올리브영</a><span class="ls5"></span>
								<a href="#">GS샵</a><span class="ls5"></span>
								<a href="#">롯데i몰</a><span class="ls5"></span>
								<a href="#">CJmall</a><span class="ls5"></span>
								<a href="#">신세계몰</a><span class="ls5"></span>
								<a href="#">롯데ON</a>
							</div>
						</div>
						<div class="box-goods">
							<div class="shop-control">
								<div class="num-box">
									<em class="current" >1</em >/ 19	</div>
								<div class="btn-box">
									<a href="#" role="btn" class="goods-btn-prev1"></a>
									<a href="#" role="btn" class="goods-btn-next1"></a>
								</div>
							</div>
						</div>
						<div class="box-event"></div>
					</div>
					<div class="group-shop mall">쇼핑몰
						<div class="mall-body1"></div>
						<div class="mall-body2"></div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="box-container-footer">
	<div class="container"></div>
</div>
</body>
</html>