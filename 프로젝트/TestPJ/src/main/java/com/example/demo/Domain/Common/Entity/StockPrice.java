package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"stockCode", "basDt"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockPrice {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)


    /** srtnCd - 종목코드 */
    @Id
    private String stockCode;

    /** basDt - 기준일자 */
    private String basDt;

    /** clpr - 종가 */
    private Long clpr;

    /** mkp - 시가 */
    private Long mkp;

    /** hipr - 고가 */
    private Long hipr;

    /** lopr - 저가 */
    private Long lopr;

    /** trqu - 거래량 */
    private Long trqu;
}
