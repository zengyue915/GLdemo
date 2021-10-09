package demo.service.impl;

import demo.DemoApplicationTest;
import demo.service.ICoodinatesService;
import demo.vo.CommentVo;
import demo.vo.CoordinateVo;
import demo.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CoordinatesServiceTest extends DemoApplicationTest {
    @Autowired
    private ICoodinatesService coodinatesService;

    @Test
    public void testneighborsDetails(){
        //List<CoordinateVo> listResponseVo = coodinatesService.neighborsDetails("10", "12.5", 3);

        List<CoordinateVo> listResponseVo2 = coodinatesService.neighborsDetailsLimit("75", "32", 3);
        //ResponseVo<List<CoordinateVo>> listResponseVo = coodinatesService.neighborsDetails("111", "12.5", 3);
    }

    @Test
    public void testupdateComments() {
        ResponseVo<CommentVo> actual = coodinatesService.updateComments("TEST! TEST! TEST!", "GRALJ170423.01+713707.57");
        Assert.assertTrue(actual.getData().isSucceed());
    }

    @Test
    public void testneighborsDetailsLimit() {
        System.out.println("BEFORE LIST");
        String expected = "[CoordinateVo{ID='GRALJ000710.01+005329.10', RA=1.791709875, DE=0.891417625, MagFilter='Gaia G', MagBrightness=17.7, MagFaintest=19.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.8\".', Comment='\n" +
                "2021-08-09 14:36:07\n" +
                "lolol\n" +
                "\n" +
                "2021-08-16 10:50:49\n" +
                "hi\n" +
                "\n" +
                "2021-08-16 10:51:38\n" +
                "hello\n" +
                "\n" +
                "2021-08-16 10:52:37\n" +
                "11111\n" +
                "\n" +
                "2021-08-16 10:54:22\n" +
                "2222\n" +
                "\n" +
                "2021-08-16 10:56:06\n" +
                "3333\n" +
                "\n" +
                "2021-08-16 10:56:12\n" +
                "44444\n" +
                "\n" +
                "2021-08-16 10:56:23\n" +
                "5555\n" +
                "\n" +
                "2021-08-16 10:56:32\n" +
                "6666\n" +
                "\n" +
                "2021-08-16 10:57:13\n" +
                "7777\n" +
                "\n" +
                "2021-08-16 11:03:54\n" +
                "hello my name is bob. I like to build stuff during my free time and i have lots of fun!'}, CoordinateVo{ID='GRALJ000251.19+130915.99', RA=0.713302966, DE=13.1544411, MagFilter='Gaia G', MagBrightness=19.7, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.7\".', Comment='\n" +
                "2021-06-21 20:08:39\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:40\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:51\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:18:44\n" +
                "haha\n" +
                "\n" +
                "2021-08-08 22:57:24\n" +
                "kok'}, CoordinateVo{ID='GRALJ005408.29+041525.91', RA=13.53452, DE=4.257198, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 3 sigma due to plx. Color difference is only 0.01+/-0.2 Separation 1\".', Comment='\n" +
                "2021-08-07 20:51:15\n" +
                "lol\n" +
                "\n" +
                "2021-08-07 20:51:20\n" +
                "hi\n" +
                "\n" +
                "2021-08-07 21:32:47\n" +
                "hello it is sunny today!\n" +
                "\n" +
                "2021-08-08 21:12:18\n" +
                "tonight is cold\n" +
                "\n" +
                "2021-08-08 21:16:58\n" +
                "new comment!\n" +
                "\n" +
                "2021-08-08 21:23:30\n" +
                "newest comment\n" +
                "\n" +
                "2021-08-08 21:24:25\n" +
                "hallo\n" +
                "\n" +
                "2021-08-08 21:27:00\n" +
                "hihihih\n" +
                "\n" +
                "2021-08-08 21:30:02\n" +
                "replace\n" +
                "\n" +
                "2021-08-08 21:32:37\n" +
                "cache\n" +
                "\n" +
                "2021-08-08 21:33:31\n" +
                "too fast\n" +
                "\n" +
                "2021-08-08 21:34:28\n" +
                "boolean\n" +
                "\n" +
                "2021-08-08 21:35:54\n" +
                "timeout\n" +
                "\n" +
                "2021-08-08 21:36:28\n" +
                "timeout2\n" +
                "\n" +
                "2021-08-08 21:37:38\n" +
                "remove\n" +
                "\n" +
                "2021-08-08 21:38:33\n" +
                "removeremove\n" +
                "\n" +
                "2021-08-09 14:36:40\n" +
                "qutomatically'}, CoordinateVo{ID='GRALJ004145.43-083307.65', RA=10.4393, DE=-8.552125, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + one source pm). Color difference only 0.28+/-0.22 mag. Separation 2.4\".', Comment='null'}, CoordinateVo{ID='GRALJ011229.41+151214.22', RA=18.1225246, DE=15.2039504, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx). No color information. Separation 1.0\".', Comment='null'}, CoordinateVo{ID='GRALJ224411.34-055049.6', RA=341.0472872, DE=-5.847131, MagFilter='Gaia G', MagBrightness=17.8, MagFaintest=18.2, QSOorigin='null', Method='Wavelet', PossibleType='Double', CandidateStatus='1', Notes='PRIORITY. Perfect standing astrometry. Very good close-pair candidate. Separation ~1.02\"', Comment='null'}, CoordinateVo{ID='GRALJ225943.79-161014.91', RA=344.9325, DE=-16.17081, MagFilter='Gaia G', MagBrightness=20.5, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). Color difference of 0.2+/-0.2. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRAL224636231+221303555', RA=341.6510899, DE=22.21726058, MagFilter='Gaia G', MagBrightness=18.859913, MagFaintest=19.547337, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='Probably galaxy mergers. Very low density region, presence of a QSO (LEDA1665792 at z=0.15576), SDSS spectrum available, difference between QSO and SE image: Gaia dcolor=0.1, PS1 dcolor=0.230, SDSS dcolor=1.256, difference between QSO and SW image: PS1 dcolor=4.217 (but objid=134663416503911209 has unspecified error on g,r mags), SDSS dcolor=0.565. QSO can be lensed, but has a low z, take SED of the 2 south images.', Comment='null'}, CoordinateVo{ID='GRALJ222905.45+182110.83', RA=337.272705, DE=18.353009, MagFilter='Gaia G', MagBrightness=19.0, MagFaintest=18.2, QSOorigin='null', Method='ZTFHighCorr', PossibleType='Quad', CandidateStatus='1', Notes='Quad. Candidate for an unresolved quad in crossbow configuration. 1.1\" separation', Comment='null'}, CoordinateVo{ID='GRALJ015749.72+092313.37', RA=29.45715173, DE=9.387046923, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information', Comment='null'}]";
        Assert.assertEquals(expected, coodinatesService.neighborsDetailsLimit("1", "2", 10).toString());
    }

    @Test
    public void testNeighborsDetailsAll() {
        String expected = "[CoordinateVo{ID='GRALJ000710.01+005329.10', RA=1.791709875, DE=0.891417625, MagFilter='Gaia G', MagBrightness=17.7, MagFaintest=19.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.8\".', Comment='\n" +
                "2021-08-09 14:36:07\n" +
                "lolol\n" +
                "\n" +
                "2021-08-16 10:50:49\n" +
                "hi\n" +
                "\n" +
                "2021-08-16 10:51:38\n" +
                "hello\n" +
                "\n" +
                "2021-08-16 10:52:37\n" +
                "11111\n" +
                "\n" +
                "2021-08-16 10:54:22\n" +
                "2222\n" +
                "\n" +
                "2021-08-16 10:56:06\n" +
                "3333\n" +
                "\n" +
                "2021-08-16 10:56:12\n" +
                "44444\n" +
                "\n" +
                "2021-08-16 10:56:23\n" +
                "5555\n" +
                "\n" +
                "2021-08-16 10:56:32\n" +
                "6666\n" +
                "\n" +
                "2021-08-16 10:57:13\n" +
                "7777\n" +
                "\n" +
                "2021-08-16 11:03:54\n" +
                "hello my name is bob. I like to build stuff during my free time and i have lots of fun!'}, CoordinateVo{ID='GRALJ000251.19+130915.99', RA=0.713302966, DE=13.1544411, MagFilter='Gaia G', MagBrightness=19.7, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.7\".', Comment='\n" +
                "2021-06-21 20:08:39\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:40\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:51\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:18:44\n" +
                "haha\n" +
                "\n" +
                "2021-08-08 22:57:24\n" +
                "kok'}, CoordinateVo{ID='GRALJ005408.29+041525.91', RA=13.53452, DE=4.257198, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 3 sigma due to plx. Color difference is only 0.01+/-0.2 Separation 1\".', Comment='\n" +
                "2021-08-07 20:51:15\n" +
                "lol\n" +
                "\n" +
                "2021-08-07 20:51:20\n" +
                "hi\n" +
                "\n" +
                "2021-08-07 21:32:47\n" +
                "hello it is sunny today!\n" +
                "\n" +
                "2021-08-08 21:12:18\n" +
                "tonight is cold\n" +
                "\n" +
                "2021-08-08 21:16:58\n" +
                "new comment!\n" +
                "\n" +
                "2021-08-08 21:23:30\n" +
                "newest comment\n" +
                "\n" +
                "2021-08-08 21:24:25\n" +
                "hallo\n" +
                "\n" +
                "2021-08-08 21:27:00\n" +
                "hihihih\n" +
                "\n" +
                "2021-08-08 21:30:02\n" +
                "replace\n" +
                "\n" +
                "2021-08-08 21:32:37\n" +
                "cache\n" +
                "\n" +
                "2021-08-08 21:33:31\n" +
                "too fast\n" +
                "\n" +
                "2021-08-08 21:34:28\n" +
                "boolean\n" +
                "\n" +
                "2021-08-08 21:35:54\n" +
                "timeout\n" +
                "\n" +
                "2021-08-08 21:36:28\n" +
                "timeout2\n" +
                "\n" +
                "2021-08-08 21:37:38\n" +
                "remove\n" +
                "\n" +
                "2021-08-08 21:38:33\n" +
                "removeremove\n" +
                "\n" +
                "2021-08-09 14:36:40\n" +
                "qutomatically'}, CoordinateVo{ID='GRALJ004145.43-083307.65', RA=10.4393, DE=-8.552125, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + one source pm). Color difference only 0.28+/-0.22 mag. Separation 2.4\".', Comment='null'}, CoordinateVo{ID='GRALJ011229.41+151214.22', RA=18.1225246, DE=15.2039504, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx). No color information. Separation 1.0\".', Comment='null'}, CoordinateVo{ID='GRALJ224411.34-055049.6', RA=341.0472872, DE=-5.847131, MagFilter='Gaia G', MagBrightness=17.8, MagFaintest=18.2, QSOorigin='null', Method='Wavelet', PossibleType='Double', CandidateStatus='1', Notes='PRIORITY. Perfect standing astrometry. Very good close-pair candidate. Separation ~1.02\"', Comment='null'}, CoordinateVo{ID='GRALJ225943.79-161014.91', RA=344.9325, DE=-16.17081, MagFilter='Gaia G', MagBrightness=20.5, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). Color difference of 0.2+/-0.2. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRAL224636231+221303555', RA=341.6510899, DE=22.21726058, MagFilter='Gaia G', MagBrightness=18.859913, MagFaintest=19.547337, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='Probably galaxy mergers. Very low density region, presence of a QSO (LEDA1665792 at z=0.15576), SDSS spectrum available, difference between QSO and SE image: Gaia dcolor=0.1, PS1 dcolor=0.230, SDSS dcolor=1.256, difference between QSO and SW image: PS1 dcolor=4.217 (but objid=134663416503911209 has unspecified error on g,r mags), SDSS dcolor=0.565. QSO can be lensed, but has a low z, take SED of the 2 south images.', Comment='null'}, CoordinateVo{ID='GRALJ222905.45+182110.83', RA=337.272705, DE=18.353009, MagFilter='Gaia G', MagBrightness=19.0, MagFaintest=18.2, QSOorigin='null', Method='ZTFHighCorr', PossibleType='Quad', CandidateStatus='1', Notes='Quad. Candidate for an unresolved quad in crossbow configuration. 1.1\" separation', Comment='null'}, CoordinateVo{ID='GRALJ015749.72+092313.37', RA=29.45715173, DE=9.387046923, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information', Comment='null'}, CoordinateVo{ID='GRALJ220546.64+122745.90', RA=331.4443, DE=12.46275, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information', Comment='null'}, CoordinateVo{ID='GRALJ220648.19+184215.45', RA=331.7008, DE=18.70429, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.9\".', Comment='null'}, CoordinateVo{ID='GRALJ013933.35+352611.37', RA=24.88897, DE=35.43649, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=19.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). Color difference only 0.25+/-0.15 mag. Separation 2.3\".', Comment='\n" +
                "2021-06-21 12:27:53\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 12:28:36\n" +
                "hi\n" +
                "\n" +
                "2021-06-21 12:31:49\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 13:02:22\n" +
                "lol'}, CoordinateVo{ID='GRALJ221213.09+355338.38', RA=333.0546, DE=35.894, MagFilter='Gaia G', MagBrightness=19.3, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 3 sigma due to proper motion. No color information. Separation 1.5\"', Comment='null'}, CoordinateVo{ID='GRALJ230352.02+443030.53', RA=345.9667, DE=44.50848, MagFilter='Gaia G', MagBrightness=20.5, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.1 sigma due to proper motion. Color diference only 0.2+/-0.2. Separation 1.7\"', Comment='null'}, CoordinateVo{ID='GRALJ014049.02+410800.34', RA=25.20427, DE=41.13343, MagFilter='Gaia G', MagBrightness=17.6, MagFaintest=18.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.7 sigma due to plx, but no proper motion (compatible with zero under ~1sigma). No color information. Separation 1.5\".', Comment='null'}, CoordinateVo{ID='GRALJ214908.89+341201.37', RA=327.287, DE=34.20038, MagFilter='Gaia G', MagBrightness=20.7, MagFaintest=20.8, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information. Color difference of 0.16+/-0.18. Separation 2.9\".', Comment='null'}, CoordinateVo{ID='GRAL211045021-161025046', RA=317.687588, DE=-16.173624, MagFilter='Gaia G', MagBrightness=17.03, MagFaintest=19.32, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='NEW. Appealing image but very weird configuration, presence of multiple QSO, compact configuration.', Comment='null'}, CoordinateVo{ID='GRALJ031104.99+055012.19', RA=47.77080179, DE=5.836720513, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=20.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ205638.72+020539.62', RA=314.1613248, DE=2.094339773, MagFilter='Gaia G', MagBrightness=15.7, MagFaintest=18.4, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1 sigma due to plx. No color information. Separation 1\"', Comment='null'}, CoordinateVo{ID='GRALJ205620.15+101322.62', RA=314.084, DE=10.22295, MagFilter='Gaia G', MagBrightness=19.4, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx. No proper motion. No color information. Separation 0.7\".', Comment='null'}, CoordinateVo{ID='GRALJ235354.79+495338.94', RA=358.4783, DE=49.89415, MagFilter='Gaia G', MagBrightness=17.8, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.9\".', Comment='null'}, CoordinateVo{ID='GRALJ015703.5+430305.89', RA=29.26459, DE=43.05164, MagFilter='Gaia G', MagBrightness=19.5, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to pmRA. No color information. Separation 2.5\".', Comment='null'}, CoordinateVo{ID='GRALJ015417.18+433319.29', RA=28.5716, DE=43.55536, MagFilter='Gaia G', MagBrightness=18.3, MagFaintest=18.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion.  Color difference only 0.24+/-0.18 mag. Separation 3.8\".', Comment='null'}, CoordinateVo{ID='GRALJ010855.16+502303.58', RA=17.22982, DE=50.38433, MagFilter='Gaia G', MagBrightness=20.3, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion. No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ013821.94+484146.78', RA=24.59142, DE=48.69633, MagFilter='Gaia G', MagBrightness=16.4, MagFaintest=17.4, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx). No color information. Separation 1.0\".', Comment='null'}, CoordinateVo{ID='GRALJ204534.76+285500.76', RA=311.3948, DE=28.91688, MagFilter='Gaia G', MagBrightness=18.7, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ204412.45+285558.57', RA=311.0519, DE=28.93294, MagFilter='Gaia G', MagBrightness=19.0, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 0.9\".', Comment='null'}, CoordinateVo{ID='GRALJ202724.21+202117.18', RA=306.8509, DE=20.35477, MagFilter='Gaia G', MagBrightness=18.0, MagFaintest=19.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 0.8\".', Comment='null'}, CoordinateVo{ID='GRALJ014603.18+591035.18', RA=26.51326, DE=59.17644, MagFilter='Gaia G', MagBrightness=20.2, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). Color difference only 0.24+/-0.18 mag. Separation 4.8\".', Comment='null'}, CoordinateVo{ID='GRALJ041747.31-012655.93', RA=64.44712126, DE=-1.44886932, MagFilter='Gaia G', MagBrightness=17.1, MagFaintest=21.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx, but no proper motion. No color information. Separation 1.2\".', Comment='null'}, CoordinateVo{ID='GRALJ034548.47+470005.12', RA=56.45194, DE=47.00142, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=18.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.7 sigma due to plx, but no proper motion. No color information. Separation 1.6\".', Comment='null'}, CoordinateVo{ID='GRALJ194350.11-130028.72', RA=295.9588, DE=-13.00798, MagFilter='Gaia G', MagBrightness=20.9, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information. No color information. Separation 2.6\".', Comment='null'}, CoordinateVo{ID='GRALJ201218.67+605408.13', RA=303.0778, DE=60.90226, MagFilter='Gaia G', MagBrightness=19.9, MagFaintest=20.8, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1 sigma due to plx, and proper motion. Color difference 0.04+/-0.32. Separation 3\".', Comment='null'}, CoordinateVo{ID='GRALJ191157.66+330917.49', RA=287.9902, DE=33.15486, MagFilter='Gaia G', MagBrightness=19.8, MagFaintest=20.6, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx. No color information. Separation 1.2\".', Comment='null'}, CoordinateVo{ID='GRALJ012255.96+783855.56', RA=20.73316, DE=78.64877, MagFilter='Gaia G', MagBrightness=18.9, MagFaintest=19.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx+pm). Color difference only 0.02 mag. Separation 2.5\".', Comment='null'}, CoordinateVo{ID='GRALJ194804.8+661334.20', RA=297.02, DE=66.22617, MagFilter='Gaia G', MagBrightness=19.5, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.8\".', Comment='null'}, CoordinateVo{ID='GRAL184911778+213402837', RA=282.299075, DE=21.567455, MagFilter='Gaia G', MagBrightness=19.52, MagFaintest=20.07, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='NEW. Ideal configuration but stands in a very high density region', Comment='null'}, CoordinateVo{ID='GRALJ184957.25+390502.04', RA=282.4885, DE=39.0839, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 2.3\".', Comment='null'}, CoordinateVo{ID='GRALJ052654.46+085259.95', RA=81.72692391, DE=8.883320469, MagFilter='Gaia G', MagBrightness=19.5, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ185231.15+514130.33', RA=283.1298, DE=51.69176, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ184034.20+390811.32', RA=280.1425, DE=39.13648, MagFilter='Gaia G', MagBrightness=20.5, MagFaintest=20.6, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). Color difference of 0.6+/0.3 mag. Separation 0.7\".', Comment='null'}, CoordinateVo{ID='GRALJ184038.14+432930.47', RA=280.1589, DE=43.4918, MagFilter='Gaia G', MagBrightness=18.8, MagFaintest=20.6, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1\".', Comment='null'}, CoordinateVo{ID='GRALJ183559.13+323252.97', RA=278.9964, DE=32.54805, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=19.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1 sigma due to plx, and 2 sigma due to proper motion. Color difference 0.1+/-0.2. Separation 1\".', Comment='null'}, CoordinateVo{ID='GRALJ045829.18+730138.39', RA=74.62159, DE=73.02733, MagFilter='Gaia G', MagBrightness=19.8, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry for one source (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion. No color information. and no information of second source. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ183527.18+502136.01', RA=278.8632, DE=50.36, MagFilter='Gaia G', MagBrightness=20.4, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx, and 2 sigma due to proper motion. Color difference 0.2+/-0.4. Separation 1.5\".', Comment='null'}, CoordinateVo{ID='GRALJ183111.05+415419.69', RA=277.796, DE=41.90547, MagFilter='Gaia G', MagBrightness=19.4, MagFaintest=19.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information Separation 2.0\".', Comment='null'}, CoordinateVo{ID='GRALJ184011.20+622347.77', RA=280.0467, DE=62.3966, MagFilter='Gaia G', MagBrightness=19.2, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to proper motion. Color difference 0.4+/-0.5. Separation 3.6\".', Comment='null'}, CoordinateVo{ID='GRAL181732641+173206500', RA=274.3856507, DE=17.53501738, MagFilter='Gaia G', MagBrightness=17.181156, MagFaintest=20.249922, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='PRIORITY. Presence of an AGN, PS1 dcolor=0.203(2), compact configuration (2.2\"), rather dense region, fold configuration with a merge of image A,B?', Comment='null'}, CoordinateVo{ID='GRALJ181536.03+205915.34', RA=273.9001, DE=20.98759, MagFilter='Gaia G', MagBrightness=20.7, MagFaintest=20.8, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.1 sigma due to plx, and 1.8 due to proper motion. Color difference 0.2+/-0.1. Separation 1.1\".', Comment='null'}, CoordinateVo{ID='GRALJ181350.84+141339.27', RA=273.4618, DE=14.22758, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Quad', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.3 sigma due to plx, and 3 sigma due to proper motion. No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ180918.40+310918.46', RA=272.3267, DE=31.15513, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx. No color information. Separation 0.8\".', Comment='null'}, CoordinateVo{ID='GRALJ055502.44-183328.69', RA=88.76018, DE=-18.55797, MagFilter='Gaia G', MagBrightness=20.6, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ174411.03+581911.40', RA=266.0459, DE=58.31983, MagFilter='Gaia G', MagBrightness=18.6, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to pmDec. No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ180007.69+014636.33', RA=270.0320548, DE=1.77675725, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=18.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion. No color information. Separation 1.1\".', Comment='null'}, CoordinateVo{ID='GRAL175108141+353309493', RA=267.7839208, DE=35.55263694, MagFilter='Gaia G', MagBrightness=19.425879, MagFaintest=19.74817, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='Low density region, compact configuration (2.4\"), presence of an AGN (WISEAJ175108.13+353309.2), good ERT pob., extragalactic field', Comment='null'}, CoordinateVo{ID='GRALJ170423.01+713707.57', RA=256.095855, DE=71.61877, MagFilter='Gaia G', MagBrightness=18.9, MagFaintest=19.2, QSOorigin='null', Method='ZTFHighCorr', PossibleType='Double', CandidateStatus='1', Notes='Aurea around redder source. Redder source has DR2 astrometry compatible with motion but this may be due to the extended emission.', Comment='\n" +
                "2021-06-21 12:00:48\n" +
                "1NEW COMMENT\n" +
                "\n" +
                "2021-06-21 12:02:59\n" +
                "Hello Word\n" +
                "\n" +
                "2021-06-21 20:10:09\n" +
                "Hello Yue'}, CoordinateVo{ID='GRALJ064653.80+512206.33', RA=101.7242, DE=51.36843, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 2.5\".', Comment='\n" +
                "2021-06-21 12:00:48\n" +
                "ddddddccccfffff111111'}, CoordinateVo{ID='GRALJ164927.81+555527.12', RA=252.3659, DE=55.9242, MagFilter='Gaia G', MagBrightness=19.1, MagFaintest=19.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 2.9\".', Comment='null'}, CoordinateVo{ID='GRALJ172201.84+201920.24', RA=260.5077, DE=20.32229, MagFilter='Gaia G', MagBrightness=20.9, MagFaintest=21.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Uncertain', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). Color difference of only 0.06+/-0.33. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRAL172201812+201920216', RA=260.507199, DE=20.32235653, MagFilter='Gaia G', MagBrightness=20.91327, MagFaintest=20.98976, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='NE image is a qso, difference in Gaia color between NE and SE images is of 0.05, compact configuration, low density region', Comment='null'}, CoordinateVo{ID='GRALJ154850.77+283013.02', RA=237.2115, DE=28.50362, MagFilter='Gaia G', MagBrightness=21.0, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.1 sigma due to plx, but no proper motion. No color information. Separation 1.7\".', Comment='null'}]";
        Assert.assertEquals(expected, coodinatesService.neighborsDetailsAll("1", "2").toString());
    }

    @Test
    public void testNeighborsDetailsLimitOrder() {
        String expected = "[CoordinateVo{ID='GRALJ000251.19+130915.99', RA=0.713302966, DE=13.1544411, MagFilter='Gaia G', MagBrightness=19.7, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.7\".', Comment='\n" +
                "2021-06-21 20:08:39\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:40\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:51\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:18:44\n" +
                "haha\n" +
                "\n" +
                "2021-08-08 22:57:24\n" +
                "kok'}, CoordinateVo{ID='GRALJ000710.01+005329.10', RA=1.791709875, DE=0.891417625, MagFilter='Gaia G', MagBrightness=17.7, MagFaintest=19.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.8\".', Comment='\n" +
                "2021-08-09 14:36:07\n" +
                "lolol\n" +
                "\n" +
                "2021-08-16 10:50:49\n" +
                "hi\n" +
                "\n" +
                "2021-08-16 10:51:38\n" +
                "hello\n" +
                "\n" +
                "2021-08-16 10:52:37\n" +
                "11111\n" +
                "\n" +
                "2021-08-16 10:54:22\n" +
                "2222\n" +
                "\n" +
                "2021-08-16 10:56:06\n" +
                "3333\n" +
                "\n" +
                "2021-08-16 10:56:12\n" +
                "44444\n" +
                "\n" +
                "2021-08-16 10:56:23\n" +
                "5555\n" +
                "\n" +
                "2021-08-16 10:56:32\n" +
                "6666\n" +
                "\n" +
                "2021-08-16 10:57:13\n" +
                "7777\n" +
                "\n" +
                "2021-08-16 11:03:54\n" +
                "hello my name is bob. I like to build stuff during my free time and i have lots of fun!'}, CoordinateVo{ID='GRALJ004145.43-083307.65', RA=10.4393, DE=-8.552125, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + one source pm). Color difference only 0.28+/-0.22 mag. Separation 2.4\".', Comment='null'}, CoordinateVo{ID='GRALJ005408.29+041525.91', RA=13.53452, DE=4.257198, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 3 sigma due to plx. Color difference is only 0.01+/-0.2 Separation 1\".', Comment='\n" +
                "2021-08-07 20:51:15\n" +
                "lol\n" +
                "\n" +
                "2021-08-07 20:51:20\n" +
                "hi\n" +
                "\n" +
                "2021-08-07 21:32:47\n" +
                "hello it is sunny today!\n" +
                "\n" +
                "2021-08-08 21:12:18\n" +
                "tonight is cold\n" +
                "\n" +
                "2021-08-08 21:16:58\n" +
                "new comment!\n" +
                "\n" +
                "2021-08-08 21:23:30\n" +
                "newest comment\n" +
                "\n" +
                "2021-08-08 21:24:25\n" +
                "hallo\n" +
                "\n" +
                "2021-08-08 21:27:00\n" +
                "hihihih\n" +
                "\n" +
                "2021-08-08 21:30:02\n" +
                "replace\n" +
                "\n" +
                "2021-08-08 21:32:37\n" +
                "cache\n" +
                "\n" +
                "2021-08-08 21:33:31\n" +
                "too fast\n" +
                "\n" +
                "2021-08-08 21:34:28\n" +
                "boolean\n" +
                "\n" +
                "2021-08-08 21:35:54\n" +
                "timeout\n" +
                "\n" +
                "2021-08-08 21:36:28\n" +
                "timeout2\n" +
                "\n" +
                "2021-08-08 21:37:38\n" +
                "remove\n" +
                "\n" +
                "2021-08-08 21:38:33\n" +
                "removeremove\n" +
                "\n" +
                "2021-08-09 14:36:40\n" +
                "qutomatically'}, CoordinateVo{ID='GRALJ010855.16+502303.58', RA=17.22982, DE=50.38433, MagFilter='Gaia G', MagBrightness=20.3, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion. No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ011229.41+151214.22', RA=18.1225246, DE=15.2039504, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx). No color information. Separation 1.0\".', Comment='null'}, CoordinateVo{ID='GRALJ012255.96+783855.56', RA=20.73316, DE=78.64877, MagFilter='Gaia G', MagBrightness=18.9, MagFaintest=19.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx+pm). Color difference only 0.02 mag. Separation 2.5\".', Comment='null'}, CoordinateVo{ID='GRALJ013821.94+484146.78', RA=24.59142, DE=48.69633, MagFilter='Gaia G', MagBrightness=16.4, MagFaintest=17.4, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx). No color information. Separation 1.0\".', Comment='null'}, CoordinateVo{ID='GRALJ013933.35+352611.37', RA=24.88897, DE=35.43649, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=19.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). Color difference only 0.25+/-0.15 mag. Separation 2.3\".', Comment='\n" +
                "2021-06-21 12:27:53\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 12:28:36\n" +
                "hi\n" +
                "\n" +
                "2021-06-21 12:31:49\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 13:02:22\n" +
                "lol'}, CoordinateVo{ID='GRALJ014049.02+410800.34', RA=25.20427, DE=41.13343, MagFilter='Gaia G', MagBrightness=17.6, MagFaintest=18.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.7 sigma due to plx, but no proper motion (compatible with zero under ~1sigma). No color information. Separation 1.5\".', Comment='null'}]";
        Assert.assertEquals(expected, coodinatesService.neighborsDetailsLimitOrder("1", "2", 10, "ra").toString());
    }

    @Test
    public void testNeighborsDetailsAllOrder() {
        String expected = "[CoordinateVo{ID='GRAL172201812+201920216', RA=260.507199, DE=20.32235653, MagFilter='Gaia G', MagBrightness=20.91327, MagFaintest=20.98976, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='NE image is a qso, difference in Gaia color between NE and SE images is of 0.05, compact configuration, low density region', Comment='null'}, CoordinateVo{ID='GRAL175108141+353309493', RA=267.7839208, DE=35.55263694, MagFilter='Gaia G', MagBrightness=19.425879, MagFaintest=19.74817, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='Low density region, compact configuration (2.4\"), presence of an AGN (WISEAJ175108.13+353309.2), good ERT pob., extragalactic field', Comment='null'}, CoordinateVo{ID='GRAL181732641+173206500', RA=274.3856507, DE=17.53501738, MagFilter='Gaia G', MagBrightness=17.181156, MagFaintest=20.249922, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='PRIORITY. Presence of an AGN, PS1 dcolor=0.203(2), compact configuration (2.2\"), rather dense region, fold configuration with a merge of image A,B?', Comment='null'}, CoordinateVo{ID='GRAL184911778+213402837', RA=282.299075, DE=21.567455, MagFilter='Gaia G', MagBrightness=19.52, MagFaintest=20.07, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='NEW. Ideal configuration but stands in a very high density region', Comment='null'}, CoordinateVo{ID='GRAL211045021-161025046', RA=317.687588, DE=-16.173624, MagFilter='Gaia G', MagBrightness=17.03, MagFaintest=19.32, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='NEW. Appealing image but very weird configuration, presence of multiple QSO, compact configuration.', Comment='null'}, CoordinateVo{ID='GRAL224636231+221303555', RA=341.6510899, DE=22.21726058, MagFilter='Gaia G', MagBrightness=18.859913, MagFaintest=19.547337, QSOorigin='null', Method='ERT', PossibleType='Quad', CandidateStatus='1', Notes='Probably galaxy mergers. Very low density region, presence of a QSO (LEDA1665792 at z=0.15576), SDSS spectrum available, difference between QSO and SE image: Gaia dcolor=0.1, PS1 dcolor=0.230, SDSS dcolor=1.256, difference between QSO and SW image: PS1 dcolor=4.217 (but objid=134663416503911209 has unspecified error on g,r mags), SDSS dcolor=0.565. QSO can be lensed, but has a low z, take SED of the 2 south images.', Comment='null'}, CoordinateVo{ID='GRALJ000251.19+130915.99', RA=0.713302966, DE=13.1544411, MagFilter='Gaia G', MagBrightness=19.7, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.7\".', Comment='\n" +
                "2021-06-21 20:08:39\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:40\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:17:51\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 20:18:44\n" +
                "haha\n" +
                "\n" +
                "2021-08-08 22:57:24\n" +
                "kok'}, CoordinateVo{ID='GRALJ000710.01+005329.10', RA=1.791709875, DE=0.891417625, MagFilter='Gaia G', MagBrightness=17.7, MagFaintest=19.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 Astrometric information is untrustworthy. Seperation is 0.8\".', Comment='\n" +
                "2021-08-09 14:36:07\n" +
                "lolol\n" +
                "\n" +
                "2021-08-16 10:50:49\n" +
                "hi\n" +
                "\n" +
                "2021-08-16 10:51:38\n" +
                "hello\n" +
                "\n" +
                "2021-08-16 10:52:37\n" +
                "11111\n" +
                "\n" +
                "2021-08-16 10:54:22\n" +
                "2222\n" +
                "\n" +
                "2021-08-16 10:56:06\n" +
                "3333\n" +
                "\n" +
                "2021-08-16 10:56:12\n" +
                "44444\n" +
                "\n" +
                "2021-08-16 10:56:23\n" +
                "5555\n" +
                "\n" +
                "2021-08-16 10:56:32\n" +
                "6666\n" +
                "\n" +
                "2021-08-16 10:57:13\n" +
                "7777\n" +
                "\n" +
                "2021-08-16 11:03:54\n" +
                "hello my name is bob. I like to build stuff during my free time and i have lots of fun!'}, CoordinateVo{ID='GRALJ004145.43-083307.65', RA=10.4393, DE=-8.552125, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + one source pm). Color difference only 0.28+/-0.22 mag. Separation 2.4\".', Comment='null'}, CoordinateVo{ID='GRALJ005408.29+041525.91', RA=13.53452, DE=4.257198, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 3 sigma due to plx. Color difference is only 0.01+/-0.2 Separation 1\".', Comment='\n" +
                "2021-08-07 20:51:15\n" +
                "lol\n" +
                "\n" +
                "2021-08-07 20:51:20\n" +
                "hi\n" +
                "\n" +
                "2021-08-07 21:32:47\n" +
                "hello it is sunny today!\n" +
                "\n" +
                "2021-08-08 21:12:18\n" +
                "tonight is cold\n" +
                "\n" +
                "2021-08-08 21:16:58\n" +
                "new comment!\n" +
                "\n" +
                "2021-08-08 21:23:30\n" +
                "newest comment\n" +
                "\n" +
                "2021-08-08 21:24:25\n" +
                "hallo\n" +
                "\n" +
                "2021-08-08 21:27:00\n" +
                "hihihih\n" +
                "\n" +
                "2021-08-08 21:30:02\n" +
                "replace\n" +
                "\n" +
                "2021-08-08 21:32:37\n" +
                "cache\n" +
                "\n" +
                "2021-08-08 21:33:31\n" +
                "too fast\n" +
                "\n" +
                "2021-08-08 21:34:28\n" +
                "boolean\n" +
                "\n" +
                "2021-08-08 21:35:54\n" +
                "timeout\n" +
                "\n" +
                "2021-08-08 21:36:28\n" +
                "timeout2\n" +
                "\n" +
                "2021-08-08 21:37:38\n" +
                "remove\n" +
                "\n" +
                "2021-08-08 21:38:33\n" +
                "removeremove\n" +
                "\n" +
                "2021-08-09 14:36:40\n" +
                "qutomatically'}, CoordinateVo{ID='GRALJ010855.16+502303.58', RA=17.22982, DE=50.38433, MagFilter='Gaia G', MagBrightness=20.3, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion. No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ011229.41+151214.22', RA=18.1225246, DE=15.2039504, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx). No color information. Separation 1.0\".', Comment='null'}, CoordinateVo{ID='GRALJ012255.96+783855.56', RA=20.73316, DE=78.64877, MagFilter='Gaia G', MagBrightness=18.9, MagFaintest=19.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx+pm). Color difference only 0.02 mag. Separation 2.5\".', Comment='null'}, CoordinateVo{ID='GRALJ013821.94+484146.78', RA=24.59142, DE=48.69633, MagFilter='Gaia G', MagBrightness=16.4, MagFaintest=17.4, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx). No color information. Separation 1.0\".', Comment='null'}, CoordinateVo{ID='GRALJ013933.35+352611.37', RA=24.88897, DE=35.43649, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=19.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). Color difference only 0.25+/-0.15 mag. Separation 2.3\".', Comment='\n" +
                "2021-06-21 12:27:53\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 12:28:36\n" +
                "hi\n" +
                "\n" +
                "2021-06-21 12:31:49\n" +
                "lol\n" +
                "\n" +
                "2021-06-21 13:02:22\n" +
                "lol'}, CoordinateVo{ID='GRALJ014049.02+410800.34', RA=25.20427, DE=41.13343, MagFilter='Gaia G', MagBrightness=17.6, MagFaintest=18.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.7 sigma due to plx, but no proper motion (compatible with zero under ~1sigma). No color information. Separation 1.5\".', Comment='null'}, CoordinateVo{ID='GRALJ014603.18+591035.18', RA=26.51326, DE=59.17644, MagFilter='Gaia G', MagBrightness=20.2, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). Color difference only 0.24+/-0.18 mag. Separation 4.8\".', Comment='null'}, CoordinateVo{ID='GRALJ015417.18+433319.29', RA=28.5716, DE=43.55536, MagFilter='Gaia G', MagBrightness=18.3, MagFaintest=18.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion.  Color difference only 0.24+/-0.18 mag. Separation 3.8\".', Comment='null'}, CoordinateVo{ID='GRALJ015703.5+430305.89', RA=29.26459, DE=43.05164, MagFilter='Gaia G', MagBrightness=19.5, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to pmRA. No color information. Separation 2.5\".', Comment='null'}, CoordinateVo{ID='GRALJ015749.72+092313.37', RA=29.45715173, DE=9.387046923, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information', Comment='null'}, CoordinateVo{ID='GRALJ031104.99+055012.19', RA=47.77080179, DE=5.836720513, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=20.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ034548.47+470005.12', RA=56.45194, DE=47.00142, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=18.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.7 sigma due to plx, but no proper motion. No color information. Separation 1.6\".', Comment='null'}, CoordinateVo{ID='GRALJ041747.31-012655.93', RA=64.44712126, DE=-1.44886932, MagFilter='Gaia G', MagBrightness=17.1, MagFaintest=21.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx, but no proper motion. No color information. Separation 1.2\".', Comment='null'}, CoordinateVo{ID='GRALJ045829.18+730138.39', RA=74.62159, DE=73.02733, MagFilter='Gaia G', MagBrightness=19.8, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry for one source (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion. No color information. and no information of second source. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ052654.46+085259.95', RA=81.72692391, DE=8.883320469, MagFilter='Gaia G', MagBrightness=19.5, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ055502.44-183328.69', RA=88.76018, DE=-18.55797, MagFilter='Gaia G', MagBrightness=20.6, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ064653.80+512206.33', RA=101.7242, DE=51.36843, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 2.5\".', Comment='\n" +
                "2021-06-21 12:00:48\n" +
                "ddddddccccfffff111111'}, CoordinateVo{ID='GRALJ154850.77+283013.02', RA=237.2115, DE=28.50362, MagFilter='Gaia G', MagBrightness=21.0, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.1 sigma due to plx, but no proper motion. No color information. Separation 1.7\".', Comment='null'}, CoordinateVo{ID='GRALJ164927.81+555527.12', RA=252.3659, DE=55.9242, MagFilter='Gaia G', MagBrightness=19.1, MagFaintest=19.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 2.9\".', Comment='null'}, CoordinateVo{ID='GRALJ170423.01+713707.57', RA=256.095855, DE=71.61877, MagFilter='Gaia G', MagBrightness=18.9, MagFaintest=19.2, QSOorigin='null', Method='ZTFHighCorr', PossibleType='Double', CandidateStatus='1', Notes='Aurea around redder source. Redder source has DR2 astrometry compatible with motion but this may be due to the extended emission.', Comment='\n" +
                "2021-06-21 12:00:48\n" +
                "1NEW COMMENT\n" +
                "\n" +
                "2021-06-21 12:02:59\n" +
                "Hello Word\n" +
                "\n" +
                "2021-06-21 20:10:09\n" +
                "Hello Yue'}, CoordinateVo{ID='GRALJ172201.84+201920.24', RA=260.5077, DE=20.32229, MagFilter='Gaia G', MagBrightness=20.9, MagFaintest=21.0, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Uncertain', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). Color difference of only 0.06+/-0.33. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ174411.03+581911.40', RA=266.0459, DE=58.31983, MagFilter='Gaia G', MagBrightness=18.6, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to pmDec. No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ180007.69+014636.33', RA=270.0320548, DE=1.77675725, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=18.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx, but no proper motion. No color information. Separation 1.1\".', Comment='null'}, CoordinateVo{ID='GRALJ180918.40+310918.46', RA=272.3267, DE=31.15513, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx. No color information. Separation 0.8\".', Comment='null'}, CoordinateVo{ID='GRALJ181350.84+141339.27', RA=273.4618, DE=14.22758, MagFilter='Gaia G', MagBrightness=18.4, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Quad', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.3 sigma due to plx, and 3 sigma due to proper motion. No color information. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ181536.03+205915.34', RA=273.9001, DE=20.98759, MagFilter='Gaia G', MagBrightness=20.7, MagFaintest=20.8, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.1 sigma due to plx, and 1.8 due to proper motion. Color difference 0.2+/-0.1. Separation 1.1\".', Comment='null'}, CoordinateVo{ID='GRALJ183111.05+415419.69', RA=277.796, DE=41.90547, MagFilter='Gaia G', MagBrightness=19.4, MagFaintest=19.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information Separation 2.0\".', Comment='null'}, CoordinateVo{ID='GRALJ183527.18+502136.01', RA=278.8632, DE=50.36, MagFilter='Gaia G', MagBrightness=20.4, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx, and 2 sigma due to proper motion. Color difference 0.2+/-0.4. Separation 1.5\".', Comment='null'}, CoordinateVo{ID='GRALJ183559.13+323252.97', RA=278.9964, DE=32.54805, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=19.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1 sigma due to plx, and 2 sigma due to proper motion. Color difference 0.1+/-0.2. Separation 1\".', Comment='null'}, CoordinateVo{ID='GRALJ184011.20+622347.77', RA=280.0467, DE=62.3966, MagFilter='Gaia G', MagBrightness=19.2, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to proper motion. Color difference 0.4+/-0.5. Separation 3.6\".', Comment='null'}, CoordinateVo{ID='GRALJ184034.20+390811.32', RA=280.1425, DE=39.13648, MagFilter='Gaia G', MagBrightness=20.5, MagFaintest=20.6, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). Color difference of 0.6+/0.3 mag. Separation 0.7\".', Comment='null'}, CoordinateVo{ID='GRALJ184038.14+432930.47', RA=280.1589, DE=43.4918, MagFilter='Gaia G', MagBrightness=18.8, MagFaintest=20.6, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1\".', Comment='null'}, CoordinateVo{ID='GRALJ184957.25+390502.04', RA=282.4885, DE=39.0839, MagFilter='Gaia G', MagBrightness=20.0, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 2.3\".', Comment='null'}, CoordinateVo{ID='GRALJ185231.15+514130.33', RA=283.1298, DE=51.69176, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ191157.66+330917.49', RA=287.9902, DE=33.15486, MagFilter='Gaia G', MagBrightness=19.8, MagFaintest=20.6, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 2 sigma due to plx. No color information. Separation 1.2\".', Comment='null'}, CoordinateVo{ID='GRALJ194350.11-130028.72', RA=295.9588, DE=-13.00798, MagFilter='Gaia G', MagBrightness=20.9, MagFaintest=20.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information. No color information. Separation 2.6\".', Comment='null'}, CoordinateVo{ID='GRALJ194804.8+661334.20', RA=297.02, DE=66.22617, MagFilter='Gaia G', MagBrightness=19.5, MagFaintest=20.3, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm). No color information. Separation 1.8\".', Comment='null'}, CoordinateVo{ID='GRALJ201218.67+605408.13', RA=303.0778, DE=60.90226, MagFilter='Gaia G', MagBrightness=19.9, MagFaintest=20.8, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1 sigma due to plx, and proper motion. Color difference 0.04+/-0.32. Separation 3\".', Comment='null'}, CoordinateVo{ID='GRALJ202724.21+202117.18', RA=306.8509, DE=20.35477, MagFilter='Gaia G', MagBrightness=18.0, MagFaintest=19.9, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 0.8\".', Comment='null'}, CoordinateVo{ID='GRALJ204412.45+285558.57', RA=311.0519, DE=28.93294, MagFilter='Gaia G', MagBrightness=19.0, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 0.9\".', Comment='null'}, CoordinateVo{ID='GRALJ204534.76+285500.76', RA=311.3948, DE=28.91688, MagFilter='Gaia G', MagBrightness=18.7, MagFaintest=21.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.4\".', Comment='null'}, CoordinateVo{ID='GRALJ205620.15+101322.62', RA=314.084, DE=10.22295, MagFilter='Gaia G', MagBrightness=19.4, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.5 sigma due to plx. No proper motion. No color information. Separation 0.7\".', Comment='null'}, CoordinateVo{ID='GRALJ205638.72+020539.62', RA=314.1613248, DE=2.094339773, MagFilter='Gaia G', MagBrightness=15.7, MagFaintest=18.4, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1 sigma due to plx. No color information. Separation 1\"', Comment='null'}, CoordinateVo{ID='GRALJ214908.89+341201.37', RA=327.287, DE=34.20038, MagFilter='Gaia G', MagBrightness=20.7, MagFaintest=20.8, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information. Color difference of 0.16+/-0.18. Separation 2.9\".', Comment='null'}, CoordinateVo{ID='GRALJ220546.64+122745.90', RA=331.4443, DE=12.46275, MagFilter='Gaia G', MagBrightness=20.1, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='No astrometric information', Comment='null'}, CoordinateVo{ID='GRALJ220648.19+184215.45', RA=331.7008, DE=18.70429, MagFilter='Gaia G', MagBrightness=19.6, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.9\".', Comment='null'}, CoordinateVo{ID='GRALJ221213.09+355338.38', RA=333.0546, DE=35.894, MagFilter='Gaia G', MagBrightness=19.3, MagFaintest=20.2, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 3 sigma due to proper motion. No color information. Separation 1.5\"', Comment='null'}, CoordinateVo{ID='GRALJ222905.45+182110.83', RA=337.272705, DE=18.353009, MagFilter='Gaia G', MagBrightness=19.0, MagFaintest=18.2, QSOorigin='null', Method='ZTFHighCorr', PossibleType='Quad', CandidateStatus='1', Notes='Quad. Candidate for an unresolved quad in crossbow configuration. 1.1\" separation', Comment='null'}, CoordinateVo{ID='GRALJ224411.34-055049.6', RA=341.0472872, DE=-5.847131, MagFilter='Gaia G', MagBrightness=17.8, MagFaintest=18.2, QSOorigin='null', Method='Wavelet', PossibleType='Double', CandidateStatus='1', Notes='PRIORITY. Perfect standing astrometry. Very good close-pair candidate. Separation ~1.02\"', Comment='null'}, CoordinateVo{ID='GRALJ225943.79-161014.91', RA=344.9325, DE=-16.17081, MagFilter='Gaia G', MagBrightness=20.5, MagFaintest=20.7, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). Color difference of 0.2+/-0.2. Separation 1.3\".', Comment='null'}, CoordinateVo{ID='GRALJ230352.02+443030.53', RA=345.9667, DE=44.50848, MagFilter='Gaia G', MagBrightness=20.5, MagFaintest=20.5, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='DR2 astrometry (plx+pm) compatible with zero within 1.1 sigma due to proper motion. Color diference only 0.2+/-0.2. Separation 1.7\"', Comment='null'}, CoordinateVo{ID='GRALJ235354.79+495338.94', RA=358.4783, DE=49.89415, MagFilter='Gaia G', MagBrightness=17.8, MagFaintest=20.1, QSOorigin='null', Method='ZTFEnsemble', PossibleType='Double', CandidateStatus='1', Notes='Perfectly still DR2 astrometry (plx + pm for one source). No color information. Separation 1.9\".', Comment='null'}]";
        Assert.assertEquals(expected, coodinatesService.neighborsDetailsAllOrder("1", "2", "ra").toString());
    }
}
